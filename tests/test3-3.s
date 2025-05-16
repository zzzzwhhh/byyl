.arch armv7ve
.arm
.fpu vfpv4
.text
.align 1
.global main
.type main, %function
main:
	push {r10,fp}
	sub sp,sp,#12
	add fp,sp,#0
	movw r0,#:lower16:10
	str r0,[fp,#4]
	ldr r0,[fp,#4]
	movw r1,#:lower16:3
	sdiv r2,r0,r1
	str r2,[fp,#8]
	ldr r0,[fp,#8]
	str r0,[fp]
	b .L0
.L0:
	ldr r0,[fp]
	add fp,fp,#12
	mov sp,fp
	pop {r10,fp}
	bx lr
