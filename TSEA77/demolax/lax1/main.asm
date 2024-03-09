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
sbis PINB,1
jmp MAIN
inc r16
CHECK_INC_DONE:
sbic PINB,1
jmp CHECK_INC_DONE
ret

CHECK_DIS:
sbis PINB,2
jmp MAIN
CHECK_DIS_DONE:
sbic PINB,2
jmp CHECK_DIS_DONE
ret

