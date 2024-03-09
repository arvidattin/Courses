;Kort signal 1 BEEP
;L�ng signal 3 BEEP
;Mellan teckendelar 1 NO_BEEP
;Mellan tecken 3 NO_BEEP
;Mellan ord 7 NO_BEEP
;


; Replace with your application code
	
	ldi	r16, HIGH(RAMEND) ; stackpekaren s�tts f�r att kunna anv�nda subrutiner 
	out	SPH, r16
	ldi	r16, LOW(RAMEND)
	out	SPL, r16
	
	ldi	r17, $FF ; ljud ut
	out	DDRB, r17
	
	ldi r19,$20 ; ett mellanslag
	.def MELLANSLAG = r19;

	.def N = r18 ; best�mmer hur m�nga BEEP
	.equ SPEED = 100 ; s�ndningshastighet
	.equ PITCH = 200 ; tonl�ge

	START:
	ldi	ZL, LOW(MESSAGE*2) 
	ldi	ZH, HIGH(MESSAGE*2)

	/* Huvudprogram som s�nder Morse str�ngen */
	MORSE: 
	clr r16

	call GET_CHAR ; h�mtar meddelandet i ASCII
	
	subi r16,$41 
	call LOOK_UP
	call SEND ; r16 har r�tt karakt�r, ska BEEPas ut
	
	ldi N,$03
	call NO_BEEP ; 3 NO_BEEP mellan karakt�rer

	jmp MORSE ; loopar tbx till ny karakt�r

	/* H�mtar n�sta ASCII tecken ur MESSAGE */
	GET_CHAR:
	lpm r16,Z+ ; lpm = load from program memory. Postinkrement: Z pekaren flyttar mellan bytes i flash
	cpi r16, $00 ; om meddelandet slutar p� nul s� �r vi klara
	breq START
	ret 

	/* �vers�tter ASCII till bin�rkod */
	LOOK_UP: 
	push ZH ; push position fr�n flash till stack
	push ZL

	ldi	ZL, LOW(BTAB*2) 
	ldi	ZH, HIGH(BTAB*2)
	add ZL,r16
	lpm r16,Z
	pop ZL ; poppar till r16
	pop ZH
	ret
	
	SEND: ; N�r vi kommer hit har vi f�tt en av karakt�rerna till bin�rt. ligger i r16 o ska s�ndas till portB genom att ta "lsl" p� alla bitar.
	 ;under progress
	ret

	BEEP_SHORT:
	call	BEEP				; 1 BEEP
	call	NO_BEEP				; 1 NO_BEEP
	jmp		BDONE

	BEEP_LONG:
	call	BEEP*3				; 3 BEEP				
	call	NOBEEP				; 1 NO_BEEP
	jmp		BDONE				

	BEEP:; under progress
	ldi r22,$FF
	PORT B FF


	NO_BEEP: ; under progress
	ldi r22,$00

	/* Meddelandet i ASCII */
	MESSAGE: 
	.db "DATORTEKNIK", $00 ; Avslutas med nul alltid
	
	/* register f�r Morse tecken */
	BTAB: 
	.db $60, $88, $A8, $90, $40, $28, $D0, $08, $20, $78, $B0, $48, $E0, $A0, $F0, $68, $D8, $50, $10, $C0, $30, $18, $70, $98, $B8, $C8 ; A -> Z 