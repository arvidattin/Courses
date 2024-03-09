SETUP:
	.def N=r18
	.equ SPEED = 25	
	.equ PITCH = 255

	ldi	r16, HIGH(RAMEND) ; stackpekaren s�tts f�r att kunna anv�nda subrutiner 
	out	SPH, r16
	ldi	r16, LOW(RAMEND)
	out	SPL, r16
	ldi	r16, $FF
	out	DDRB, r16	;ljud ut

MORSE:; Sl� upp i tabellen
ldi ZH,HIGH(TAB*2) ; Ber�kna tabellstart
ldi ZL,LOW(TAB*2) ; ---��---
lpm r16,Z ; H�mta 0
call PROCESS ; G�r n�got med det h�mtade v�rdet
adiw ZH:ZL,1 ; Peka ut n�sta
lpm r16,Z ; H�mta 1
call PROCESS

PROCESS:
ret



.org $0200


/* Register morse tabellen */
TAB:		;Morse tabell
	.db 0, 1, 2, 3, 4, 5


	TAB: .db 0, 1, 2, 3, 4, 5 ; j�mnt antal bytes definieras
