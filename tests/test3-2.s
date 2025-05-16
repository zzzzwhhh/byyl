.arch armv7ve
.arm
.fpu vfpv4
.text
.comm a, 4, 4
.comm b, 4, 4
.comm c, 4, 4
.align 1
.global main
.type main, %function
main:
	push {r10,fp}
	sub sp,sp,#16
	add fp,sp,#0
	movw r0,#:lower16:13
	movw r10,#:lower16:a
	movt r10,#:upper16:a
	str r0,[r10]
	movw r0,#:lower16:7
	movw r10,#:lower16:b
	movt r10,#:upper16:b
	str r0,[r10]
	movw r0,#:lower16:a
	movt r0,#:upper16:a
	ldr r0,[r0]
	movw r1,#:lower16:b
	movt r1,#:upper16:b
	ldr r1,[r1]
	sub r2,r0,r1
	str r2,[fp,#8]
	ldr r0,[fp,#8]
	movw r10,#:lower16:c
	movt r10,#:upper16:c
	str r0,[r10]
	movw r0,#:lower16:c
	movt r0,#:upper16:c
	ldr r0,[r0]
	rsb r1,r0,#0
	str r1,[fp,#12]
	ldr r0,[fp,#12]
	str r0,[fp,#4]

	ldr r0,[fp]
	add fp,fp,#16
	mov sp,fp
	pop {r10,fp}
	bx lr
