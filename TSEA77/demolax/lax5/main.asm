;
; AssemblerApplication18.asm
;
; Created: 2022-05-22 12:44:25
; Author : Arvid
;


; Replace with your application code
COLD:

ldi r16, LOW(RAMEND)
out SPL, r16
ldi r16, HIGH(RAMEND)
out SPH, r16

WARM:
ldi r16, $FF
out DDRC, r16
ldi r16, $FF
out DDRB, r16
ldi r16, $00
out DDRA, r16

START:
sbis PINA,4
jmp START
in r16, PINA
andi r16, $0F
call NORMAL

NORMAL:
mov r17, r16
swap r16
add r16, r17
call SEND
jmp WAIT1

INVERSE:
ldi r18, $0F
clr r17
mov r17, r16
swap r16
eor r17, r18
add r16, r17
call SEND
jmp WAIT2

SEND:
out PORTB, r16
ret

WAIT1:
sbis PINA,4
jmp WAIT1
clr r17
in r17, PINA
cpi r17, 16
breq INVERSE
call NORMAL
jmp WAIT1

WAIT2:
sbis PINA,4
jmp WAIT2
clr r17
ldi r17, PINA
cpi r17, $19
breq NORMAL
call INVERSE
jmp WAIT2








/*

WAIT:
sbis PINA,4
jmp WAIT
call INV

WAIT2:
sbis PINA,4
jmp WAIT2
call WAIT


INV:
in r16, PINA
andi r16, $0F
ldi r18, $0F
mov r17, r16
swap r16
eor r17, r18
add r16, r17
out PORTB, r16
jmp	INV
*/
/*
WAIT:
sbis PINA,4
jmp WAIT
in r16, PINA
cpi r16, 16
breq INV

SEND:
andi r16, $0F
mov r17, r16
swap r16
add r16, r17
out PORTB, r16
jmp WAIT2


INV:
push r16
ldi r18, $0F
ldi r17, PINA
swap r16
eor r17, r18
add r16, r17
jmp	WAIT2

WAIT2:
sbic PINA,4
jmp WAIT2
jmp WAIT
*/


/*



WAIT2:
sbic PINA,4
jmp WAIT2
jmp WAIT


READ:
sbis PINA,4
jmp READ
in r16, PINA
andi r16, $0F
cpi r16,8
breq OUT_INV
jmp	OUTN

OUTN:
out PORTB, r16
out PORTC, r16
jmp WAIT2

OUT_INV:
out PORTB, r16
ldi r17, $0F
eor r16, r17
out PORTC, r16
jmp WAIT2





*/