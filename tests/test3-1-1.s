	.arch armv7-a
	.fpu vfpv3-d16
	.eabi_attribute 28, 1
	.eabi_attribute 20, 1
	.eabi_attribute 21, 1
	.eabi_attribute 23, 3
	.eabi_attribute 24, 1
	.eabi_attribute 25, 1
	.eabi_attribute 26, 2
	.eabi_attribute 30, 6
	.eabi_attribute 34, 1
	.eabi_attribute 18, 4
	.file	"test3-1.c"
	.text
	.global	__aeabi_idiv
	.global	__aeabi_idivmod
	.align	1
	.global	main
	.syntax unified
	.thumb
	.thumb_func
	.type	main, %function
main:
	@ args = 0, pretend = 0, frame = 24
	@ frame_needed = 1, uses_anonymous_args = 0
	push	{r7, lr}
	sub	sp, sp, #24
	add	r7, sp, #0
	mvn	r3, #2
	str	r3, [r7, #4]
	movs	r3, #4
	str	r3, [r7, #8]
	movs	r3, #15
	str	r3, [r7, #12]
	ldr	r3, [r7, #4]
	ldr	r2, [r7, #8]
	mul	r3, r2, r3
	str	r3, [r7, #16]
	ldr	r1, [r7, #4]
	ldr	r0, [r7, #16]
	bl	__aeabi_idiv(PLT)
	mov	r3, r0
	str	r3, [r7, #8]
	ldr	r3, [r7, #4]
	ldr	r1, [r7, #8]
	mov	r0, r3
	bl	__aeabi_idivmod(PLT)
	mov	r3, r1
	str	r3, [r7, #20]
	ldr	r2, [r7, #4]
	ldr	r3, [r7, #8]
	add	r2, r2, r3
	ldr	r3, [r7, #12]
	add	r3, r3, r2
	mov	r0, r3
	adds	r7, r7, #24
	mov	sp, r7
	@ sp needed
	pop	{r7, pc}
	.size	main, .-main
	.ident	"GCC: (Ubuntu 11.4.0-1ubuntu1~22.04) 11.4.0"
	.section	.note.GNU-stack,"",%progbits
