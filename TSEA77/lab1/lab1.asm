;
; AssemblerApplication5.asm
;
; Created: 2022-04-12 15:52:02
; Author : Arvid
;


; Replace with your application code
.def counter = r20
.def letter = r21

	ldi		r16, HIGH(RAMEND)	
	out		SPH, r16	
	ldi		r16, LOW(RAMEND) 
	out		SPL, r16 
	

INIT:
    clr r16
    out DDRA,r16
    ldi r16,$FF
    out DDRB,r16
 
 
START:
	call	DELAY
	sbis	PINA,0
	jmp		START

	clr		counter
	ldi		counter,4

BITS:
	call	DELAY2
	clr		r18
	in		r18, PINA
	mov		r22,r18
	andi	r22,$01
	add		letter, r22
	lsl		letter
	dec		counter
	
	cpi		counter,0
	brne	BITS
/*	sbrc	counter,0
	jmp	BITS	;kör om om carry är 0
*/
	lsr		letter
	out		PORTB,letter
	jmp		END
	


DELAY2:
	call DELAY
	call DELAY
	
DELAY:
	sbi PORTB,7
	ldi r16,21 ; Decimal bas
	/*ldi r16,10 ; Decimal bas*/
delayYttreLoop:
	ldi r17,$1F
delayInreLoop:
	dec r17
	brne delayInreLoop
	dec r16
	brne delayYttreLoop
	cbi PORTB,7
	ret
	
END:
	clr		letter
	out		PORTB,letter

