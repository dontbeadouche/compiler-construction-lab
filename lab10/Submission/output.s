.global main
msg:
.string "Final result of LHS var = %d\n"
.comm a,4
.comm b,4
.comm c,4
.comm d,4
.comm e,4
.comm f,4

main:
pushl %ebp
movl %esp, %ebp

movl $20,a
movl $30,b
movl $40,c
movl a, %eax
subl b, %eax
subl c, %eax
movl %eax,z


pushl z
pushl $msg
call printf
leave
ret
