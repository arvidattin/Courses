;
; AssemblerApplication17.asm
;
; Created: 2022-05-22 11:11:27
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
ldi r16, $00
out DDRC, r16

START:
sbis PINB, 4
jmp START
jmp LEFT

LEFT:
sbis PINB,4
jmp LEFT
in r16, PINB
andi r16, $0F
cpi r16, 15
breq WAIT
cpi r16, 10
brge LEFT
out PORTA, r16
jmp LEFT

WAIT:
sbic PINB,4
breq WAIT
jmp RIGHT

WAIT2:
sbic PINB,4
breq WAIT2
jmp LEFT

RIGHT:
sbis PINB,4
jmp RIGHT
in r16, PINB
andi r16, $0F
cpi r16, 15
breq WAIT2
cpi r16, 10
brge RIGHT
out PORTC,r16
jmp RIGHT






    
