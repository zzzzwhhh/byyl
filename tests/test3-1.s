.arch armv7ve
.arm
.fpu vfpv4
.text
.align 1
.global main
.type main, %function
main:
	push {r10,fp}
	sub sp,sp,#48
	add fp,sp,#0
	movw r0,#:lower16:3
	rsb r1,r0,#0
	str r1,[fp,#24]
	ldr r0,[fp,#24]
	str r0,[fp,#4]
	movw r0,#:lower16:4
	str r0,[fp,#12]
	movw r0,#:lower16:15
	str r0,[fp,#8]
	ldr r0,[fp,#4]
	ldr r1,[fp,#12]
	mul r2,r0,r1
	str r2,[fp,#28]
	ldr r0,[fp,#28]
	str r0,[fp,#16]
	ldr r0,[fp,#16]
	ldr r1,[fp,#4]
	sdiv r2,r0,r1
	str r2,[fp,#32]
	ldr r0,[fp,#32]
	str r0,[fp,#12]
	ldr r0,[fp,#4]
	ldr r1,[fp,#12]
	sdiv r10,r0,r1
	mul r10,r10,r1
	sub r2,r0,r10
	str r2,[fp,#36]
	ldr r0,[fp,#36]
	str r0,[fp,#20]
	ldr r0,[fp,#4]
	ldr r1,[fp,#12]
	add r2,r0,r1
	str r2,[fp,#40]
	ldr r0,[fp,#40]
	ldr r1,[fp,#8]
	add r2,r0,r1
	str r2,[fp,#44]
	ldr r0,[fp,#44]
	str r0,[fp]
	b .L0
.L0:
	ldr r0,[fp]
	add fp,fp,#48
	mov sp,fp
	pop {r10,fp}
	bx lr
