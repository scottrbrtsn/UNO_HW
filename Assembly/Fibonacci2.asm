; Fibonacci Numbers           

;This Program gives the fibonnacci number at the nth location in the series
;User provides n
; this program adds all fib numbers together to reach the desired location in the series
; This program ends by printing out the result and closing

INCLUDE Irvine32.inc

.data
fibPrompt  BYTE  "Enter a number from 1-45:    ", 0
fibResult  BYTE  "The ", 0
isPrompt   BYTE  "th Fibonnacci number is ", 0
zeroFib    BYTE  "Why don't you want to Fib a number?", 0
fibNumber  DWORD ?
.code


main PROC
     xor ecx, ecx                      ; zero registers to assist in debugging
     xor eax, eax
     mov	edx,OFFSET fibPrompt	     ; display a prompt to request a number
	call	WriteString
	mov	edx,OFFSET fibNumber            ; point to the space to store the number
	call	ReadInt         	          ; input the number
     mov fibNumber, eax
     mov ecx, fibNumber
  

     dec eax
	push eax		                   	; calculate Fib of n
	call Fib		                      ; return to eax

     mov ebx, eax                         ; save eax to print in a moment
     mov	edx,OFFSET fibResult	       ; print prompt first
	call WriteString                     ; display a String to clarify meaning of the result
     mov eax, fibNumber                   
     call WriteDec
     mov edx, OFFSET isPrompt
     call WriteString
     mov eax, ebx                       ; return result to display in final prompt
     call WriteInt                      ; display the Fib number
     call Crlf
     
     
	exit
main ENDP


Fib PROC
     
    	push ebp
	mov  ebp,esp

	mov  eax, [ebp+8]	; get n
	cmp  eax, 1		; n <=1?
	ja   L1			; yes: return 1
	mov  ecx,1		; no: jump to L1
	jmp  L2

L1:	
     dec eax             ; n - 1
     mov ecx, eax        ; save n-1
     push ecx            ; push n-1 onto stack
     push eax            ; push n-1 onto stack again for second fib call
     call Fib            ; fib n-1

     pop eax             ; pop n-1
     dec eax             ; n-2
     push ecx            ; save fib(n-1) for addition
     push eax            ; save n-1 for fib call
     call Fib            ; fib n-2
     pop eax             ; recall fib(n-2) for addition

     add ecx, eax        ; add fib(n-1) and fib(n-2)
     mov eax, ecx        ; adjust registers to return eax
   


    

L2:
     mov esp, ebp
     pop ebp
	ret  4			; clean up stack


Fib ENDP

END main