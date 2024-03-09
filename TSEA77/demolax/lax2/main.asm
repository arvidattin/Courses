;
; AssemblerApplication14.asm
;
; Created: 2022-05-21 13:43:50
; Author : Arvid
;


; Replace with your application code

INIT:
	ldi r16, LOW(RAMEND)
	out SPL, r16
	ldi r16, HIGH(RAMEND)
	out SPH, r16
HW:
    ldi r16, $FF
	out DDRA, r16
    ldi r16, $00
	out DDRB, r16


MAIN:
call CHECK_INC
call CHECK_DIS
jmp MAIN

CHECK_INC:
sbis PINB,0
ret
cpi r16,15
brge CHECK_INC_DONE
inc r16

CHECK_INC_DONE:
sbic PINB,0
jmp CHECK_INC_DONE
ret

CHECK_DIS:
sbis PINB,1
ret
out PORTA,r16

CHECK_DIS_DONE:
sbic PINB,1
jmp CHECK_DIS_DONE
clr r16
ret

