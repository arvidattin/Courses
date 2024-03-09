;
; AssemblerApplication14.asm
;
; Created: 2022-05-21 13:43:50
; Author : Arvid
;


; Replace with your application code

ldi r16, $FF
out DDRA, r16
ldi r16, $00
out DDRB,r16

ldi r16, $AA
out PORTA,r16
ldi r16, $55
out PORTA,r16
/*INIT:
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
sbic PINB, 4
call LOAD
jmp MAIN

LOAD:
in r16, PINB
andi r16, $0F
cpi r16, 10
brge TIOTAL
out PORTA, r16

TIOTAL:
subi r16, 10
ldi r17, 16
add r16, r17
out PORTA, r16
jmp KLAR


KLAR:
jmp MAIN


*/