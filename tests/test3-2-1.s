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
	.file	"test3-2.c"
	.text
	.global	a
	.bss
	.align	2
	.type	a, %object
	.size	a, 4
a:
	.space	4
	.global	b
	.align	2
	.type	b, %object
	.size	b, 4
b:
	.space	4
	.global	c
	.align	2
	.type	c, %object
	.size	c, 4
c:
	.space	4
	.text
	.align	1
	.global	main
	.syntax unified
	.thumb
	.thumb_func
	.type	main, %function
main:
	@ args = 0, pretend = 0, frame = 8
	@ frame_needed = 1, uses_anonymous_args = 0
	@ link register save eliminated.
	push	{r7}
	sub	sp, sp, #12
	add	r7, sp, #0
	ldr	r3, .L3
.LPIC0:
	add	r3, pc
	movs	r2, #13
	str	r2, [r3]
	ldr	r3, .L3+4
.LPIC1:
	add	r3, pc
	movs	r2, #7
	str	r2, [r3]
	ldr	r3, .L3+8
.LPIC2:
	add	r3, pc
	ldr	r2, [r3]
	ldr	r3, .L3+12
.LPIC3:
	add	r3, pc
	ldr	r3, [r3]
	subs	r2, r2, r3
	ldr	r3, .L3+16
.LPIC4:
	add	r3, pc
	str	r2, [r3]
	ldr	r3, .L3+20
.LPIC5:
	add	r3, pc
	ldr	r3, [r3]
	rsbs	r3, r3, #0
	str	r3, [r7, #4]
	movs	r3, #0
	mov	r0, r3
	adds	r7, r7, #12
	mov	sp, r7
	@ sp needed
	ldr	r7, [sp], #4
	bx	lr
.L4:
	.align	2
.L3:
	.word	a-(.LPIC0+4)
	.word	b-(.LPIC1+4)
	.word	a-(.LPIC2+4)
	.word	b-(.LPIC3+4)
	.word	c-(.LPIC4+4)
	.word	c-(.LPIC5+4)
	.size	main, .-main
	.ident	"GCC: (Ubuntu 11.4.0-1ubuntu1~22.04) 11.4.0"
	.section	.note.GNU-stack,"",%progbits
