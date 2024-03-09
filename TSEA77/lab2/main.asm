;Kort signal 1 BEEP
;Lång signal 3 BEEP
;Mellan teckendelar 1 NO_BEEP
;Mellan tecken 3 NO_BEEP
;Mellan ord 7 NO_BEEP
;


; Replace with your application code
	
	ldi	r16, HIGH(RAMEND) ; stackpekaren sätts för att kunna använda subrutiner 
	out	SPH, r16
	ldi	r16, LOW(RAMEND)
	out	SPL, r16
	
	ldi	r17, $FF ; ljud ut
	out	DDRB, r17
	
	ldi r19,$20 ; ett mellanslag
	.def MELLANSLAG = r19;

	.def N = r18 ; bestämmer hur många BEEP
	.equ SPEED = 100 ; sändningshastighet
	.equ PITCH = 200 ; tonläge

	START:
	ldi	ZL, LOW(MESSAGE*2) 
	ldi	ZH, HIGH(MESSAGE*2)

	/* Huvudprogram som sänder Morse strängen */
	MORSE: 
	clr r16

	call GET_CHAR ; hämtar meddelandet i ASCII
	
	subi r16,$41 
	call LOOK_UP
	call SEND ; r16 har rätt karaktär, ska BEEPas ut
	
	ldi N,$03
	call NO_BEEP ; 3 NO_BEEP mellan karaktärer

	jmp MORSE ; loopar tbx till ny karaktär

	/* Hämtar nästa ASCII tecken ur MESSAGE */
	GET_CHAR:
	lpm r16,Z+ ; lpm = load from program memory. Postinkrement: Z pekaren flyttar mellan bytes i flash
	cpi r16, $00 ; om meddelandet slutar på nul så är vi klara
	breq START
	ret 

	/* Översätter ASCII till binärkod */
	LOOK_UP: 
	push ZH ; push position från flash till stack
	push ZL

	ldi	ZL, LOW(BTAB*2) 
	ldi	ZH, HIGH(BTAB*2)
	add ZL,r16
	lpm r16,Z
	pop ZL ; poppar till r16
	pop ZH
	ret
	
	SEND: ; När vi kommer hit har vi fått en av karaktärerna till binärt. ligger i r16 o ska sändas till portB genom att ta "lsl" på alla bitar.
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
	
	/* register för Morse tecken */
	BTAB: 
	.db $60, $88, $A8, $90, $40, $28, $D0, $08, $20, $78, $B0, $48, $E0, $A0, $F0, $68, $D8, $50, $10, $C0, $30, $18, $70, $98, $B8, $C8 ; A -> Z 