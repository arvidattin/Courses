SETUP:
	.def N=r18
	.equ SPEED = 25	
	.equ PITCH = 255

	ldi	r16, HIGH(RAMEND) ; stackpekaren sätts för att kunna använda subrutiner 
	out	SPH, r16
	ldi	r16, LOW(RAMEND)
	out	SPL, r16
	ldi	r16, $FF
	out	DDRB, r16	;ljud ut

MORSE:; Slå upp i tabellen
ldi ZH,HIGH(TAB*2) ; Beräkna tabellstart
ldi ZL,LOW(TAB*2) ; ---’’---
lpm r16,Z ; Hämta 0
call PROCESS ; Gör något med det hämtade värdet
adiw ZH:ZL,1 ; Peka ut nästa
lpm r16,Z ; Hämta 1
call PROCESS

PROCESS:
ret



.org $0200


/* Register morse tabellen */
TAB:		;Morse tabell
	.db 0, 1, 2, 3, 4, 5


	TAB: .db 0, 1, 2, 3, 4, 5 ; jämnt antal bytes definieras
