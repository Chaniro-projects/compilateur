;entete
extrn lirent:proc, ecrent:proc 
extrn ecrbool:proc 
extrn ecrch:proc,ligsuiv:proc

.model SMALL
.586

.CODE
debut:
	STARTUPCODE

;ouvBloc 0
enter 0,0
;iload 0
push word ptr [bp0]

;istore -4
pop ax 
mov word ptr [bp-4],ax

;iload 0
push word ptr [bp0]

;iload 0
push word ptr [bp0]

;isup 
pop bx 
pop ax 
cmp ax,bx 
jge $+6 
push -1 
jmp $+4 
push 0 

;iffaux SINON1
pop ax
cmp ax,0
je SINON1

;iload 0
push word ptr [bp0]

;goto FSI1
jmp FSI1

SINON1:
;iload 0
push word ptr [bp0]

FSI1:
;fermebloc 2
leave
ret 2
;ouvBloc 0
enter 0,0
;iload 0
push word ptr [bp0]

;iload 0
push word ptr [bp0]

;iinf 
pop bx 
pop ax 
cmp ax,bx 
jge $+6 
push -1 
jmp $+4 
push 0 

;iffaux SINON2
pop ax
cmp ax,0
je SINON2

;iload 0
push word ptr [bp0]

;goto FSI2
jmp FSI2

SINON2:
FSI2:
;fermebloc 4
leave
ret 4
;ouvBloc 0
enter 0,0
;iload 0
push word ptr [bp0]

;iload 0
push word ptr [bp0]

;isup 
pop bx 
pop ax 
cmp ax,bx 
jge $+6 
push -1 
jmp $+4 
push 0 

;fermebloc 6
leave
ret 6
main :
;ouvBloc 0
enter 0,0
;iconst 5
push word ptr 5

;istore -8
pop ax 
mov word ptr [bp-8],ax

;lireEnt 0
lea dx,[bp0]
push dx
call lirent

;aLaLigne
call ligsuiv

;iload 0
push word ptr [bp0]

