.def counter = r16

.cseg

.org $00

jmp START

 

.org INT0addr

jmp BCD

 

.org INT1addr

jmp MUX

 
 START:
            ldi r16, LOW(RAMEND)
            out SPL, r16
            ldi r16, HIGH(RAMEND)
            out SPH, r16
            ldi r16, $03
            out DDRA, r16
            ldi r16, $FF
            out DDRB, r16
            clr counter

CLR_COUNTER:
			ldi ZL, LOW(TIME)
            ldi ZH, HIGH(TIME)
			clr r16
            st	Z+, r16
            st	Z+, r16
            st	Z+, r16
            st	Z, r16

INIT:   
			ldi r16, (1<<ISC01 | 0<<ISC00 | 1<<ISC11 | 0<<ISC10)
            out MCUCR, r16
            ldi r16, (1<<INT0 | 1<<INT1)
            out GICR, r16
            sei

WAIT:

         rjmp WAIT

 

BCD:

            push counter

            in counter,SREG

            call BCD_COUNT

            out SREG,counter

            pop counter

            reti

 

BCD_COUNT:
		
			
            ldi ZH,HIGH(TIME)

            ldi ZL,LOW(TIME)

 

CHECK:


CHECK_TEN:

            ld counter,Z
            inc counter

            cpi counter,10

            brne STORE

            clr counter

            st Z+,counter

CHECK_SIX:

            ld counter,Z

            inc counter

            cpi counter,6

            brne STORE

            clr counter

            st Z+,counter

            jmp CHECK

 

/*CLEAR:

			ldi ZL, LOW(TIME)
			ldi ZH, HIGH(TIME)
            st Z+, r16
            st Z+, r16
            st Z+, r16
            st Z, r16*/

STORE:
		   st Z,counter
			ret
			

MUX:

            push counter

            in counter,SREG

            call MUX_COUNT

            out SREG,counter

            pop counter

            reti

 

MUX_COUNT:
			push r16
            lds r16, COUNT

            ldi	ZL, LOW(TIME)
            ldi	ZH, HIGH(TIME)
            add ZL, r18
            ld	r16, Z
            ldi ZL, LOW(2*BCD_CODE)
            ldi ZH, HIGH(2*BCD_CODE)
            add ZL, r16
            lpm r16, Z
			out PORTB, r16
            out PORTA, r18
            inc r18
            cpi r18, 4
            brne MUX_COMP
            clr r18
MUX_COMP:
            pop r16
            reti



.dseg

.org $100

TIME:       .byte 4
COUNT:	.byte 1

.cseg
.org 200
BCD_CODE:       .db $3F,$30,$5B,$4F,$66,$6D,$7D,$07,$FF,$67