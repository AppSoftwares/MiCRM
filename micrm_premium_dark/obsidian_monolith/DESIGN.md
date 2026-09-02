---
name: Obsidian Monolith
colors:
  surface: '#131313'
  surface-dim: '#131313'
  surface-bright: '#393939'
  surface-container-lowest: '#0e0e0e'
  surface-container-low: '#1b1b1b'
  surface-container: '#1f1f1f'
  surface-container-high: '#2a2a2a'
  surface-container-highest: '#353535'
  on-surface: '#e2e2e2'
  on-surface-variant: '#c4c7c8'
  inverse-surface: '#e2e2e2'
  inverse-on-surface: '#303030'
  outline: '#8e9192'
  outline-variant: '#444748'
  surface-tint: '#c6c6c7'
  primary: '#ffffff'
  on-primary: '#2f3131'
  primary-container: '#e2e2e2'
  on-primary-container: '#636565'
  inverse-primary: '#5d5f5f'
  secondary: '#c8c6c8'
  on-secondary: '#303032'
  secondary-container: '#474649'
  on-secondary-container: '#b7b4b7'
  tertiary: '#ffffff'
  on-tertiary: '#2f3131'
  tertiary-container: '#e2e2e2'
  on-tertiary-container: '#636565'
  error: '#ffb4ab'
  on-error: '#690005'
  error-container: '#93000a'
  on-error-container: '#ffdad6'
  primary-fixed: '#e2e2e2'
  primary-fixed-dim: '#c6c6c7'
  on-primary-fixed: '#1a1c1c'
  on-primary-fixed-variant: '#454747'
  secondary-fixed: '#e4e2e4'
  secondary-fixed-dim: '#c8c6c8'
  on-secondary-fixed: '#1b1b1d'
  on-secondary-fixed-variant: '#474649'
  tertiary-fixed: '#e2e2e2'
  tertiary-fixed-dim: '#c6c6c7'
  on-tertiary-fixed: '#1a1c1c'
  on-tertiary-fixed-variant: '#454747'
  background: '#131313'
  on-background: '#e2e2e2'
  surface-variant: '#353535'
  card-gradient-start: '#2A2A2E'
  card-gradient-end: '#101012'
  surface-secondary: '#141414'
  text-muted: '#8E8E93'
typography:
  headline-lg:
    fontFamily: Geist
    fontSize: 32px
    fontWeight: '700'
    lineHeight: '1.2'
    letterSpacing: -0.02em
  headline-lg-mobile:
    fontFamily: Geist
    fontSize: 24px
    fontWeight: '700'
    lineHeight: '1.2'
  headline-md:
    fontFamily: Geist
    fontSize: 24px
    fontWeight: '700'
    lineHeight: '1.3'
  body-lg:
    fontFamily: Inter
    fontSize: 18px
    fontWeight: '500'
    lineHeight: '1.5'
  body-md:
    fontFamily: Inter
    fontSize: 16px
    fontWeight: '400'
    lineHeight: '1.5'
  label-md:
    fontFamily: Inter
    fontSize: 14px
    fontWeight: '600'
    lineHeight: '1.4'
    letterSpacing: 0.01em
  label-sm:
    fontFamily: Inter
    fontSize: 12px
    fontWeight: '500'
    lineHeight: '1.4'
    letterSpacing: 0.03em
rounded:
  sm: 0.5rem
  DEFAULT: 1rem
  md: 1.5rem
  lg: 2rem
  xl: 3rem
  full: 9999px
spacing:
  container-margin: 24px
  gutter: 16px
  stack-overlap: 12px
  section-gap: 40px
---

## Brand & Style
The design system embodies a "Hyper-Premium Dark" aesthetic, characterized by high-contrast monochrome values and luxurious depth. It is tailored for a sophisticated user base that values clarity, exclusivity, and focused workflows. 

The style is a fusion of **Minimalism** and **Glassmorphism**, utilizing deep blacks and radial gradients to simulate physical materials like brushed metal and polished obsidian. Motion is a key brand pillar, with "swipeable" stacked interfaces that mimic physical cards. The emotional response should be one of quiet power, precision, and effortless control. Visual noise is eliminated by removing all line-based dividers, relying instead on spatial grouping and tonal shifts to define the interface structure.

## Colors
This design system operates on a strict monochromatic scale to maintain a premium, focused atmosphere. 

- **Pure Black (#000000):** Used as the foundational canvas to ensure infinite contrast with text and maximum power efficiency on OLED screens.
- **Radial Gradients:** Applied to base cards to create a "Brushed Metal" effect, transitioning from a subtle slate grey (#2A2A2E) to a near-black (#101012).
- **Secondary Surfaces:** Used for input groups or nested containers at #141414.
- **Typography:** Headlines and CTAs use Pure White (#FFFFFF). All metadata and labels utilize a muted iOS-style grey (#8E8E93) to preserve visual hierarchy.

## Typography
The typography system uses a pairing of **Geist** for headlines and **Inter** for functional text. 

Geist provides a technical, precise character for large titles, used exclusively in Bold weights with tight letter-spacing to emphasize the premium nature of the CRM. Inter is used for its exceptional legibility in data-heavy environments. To maintain the monochrome elegance, avoid using middle-grey weights; stick to Pure White for primary reading and #8E8E93 for labels. All labels should be set in Medium or Semi-Bold to ensure they remain legible against the dark backgrounds.

## Layout & Spacing
The layout follows a **Fixed Grid** model on desktop and a **Fluid Margin** model on mobile. 

Key principles:
- **No Dividers:** Separation is achieved through 40px gaps between major sections and 16px gutters between cards.
- **Card Stacking:** Interactive modules use a "stack" layout where secondary cards peek from behind the primary card with a 12px vertical overlap.
- **Pill Navigation:** The primary navigation is a floating "Pill" container anchored at the bottom of the viewport, using internal padding of 8px and item spacing of 16px.
- **Safe Zones:** A consistent 24px outer margin is required for all mobile views to prevent content from crowding the screen edges.

## Elevation & Depth
Depth is created through **Tonal Layering** and **Material Simulation** rather than traditional drop shadows.

1.  **Level 0 (Background):** Pure #000000.
2.  **Level 1 (Base Cards):** The "Brushed Metal" radial gradient. These elements should feel heavy and structural.
3.  **Level 2 (Floating Pills & Modals):** Pure #000000 with a subtle 1px white border (10% opacity) to define edges against the black background.
4.  **Level 3 (Active Elements):** Pure White.

For swipeable cards, use a "Background Blur" of 20px on any element that passes over another to maintain the glassmorphic feel without losing the dark aesthetic.

## Shapes
The shape language is defined by extreme roundedness, creating a friendly yet high-end tactile feel. 

Base containers and secondary surfaces must use a **24px (1.5rem) radius**. Buttons, input fields, and navigation items are strictly **Pill-shaped**, using the maximum possible radius relative to their height. This "squircle" and pill approach softens the high-contrast monochrome palette, making the CRM feel modern and fluid rather than aggressive.

## Components

- **CTA Buttons:** Full pill shape. Background is Pure White (#FFFFFF) with black text. On hover/active states, apply a slight inner glow.
- **Interactive Cards:** Radial gradient backgrounds with 24px corner radius. No borders. Swipe gestures should trigger a rotation-scale animation.
- **Input Fields:** Secondary Surface color (#141414) with a pill shape. Placeholder text in #8E8E93. On focus, the background remains dark but the text turns Pure White.
- **Floating Navigation:** A black glassmorphic pill. Active icons or text are highlighted with a white circular background (pill-within-a-pill).
- **Minimalist Charts:** Line graphs should use a 2px white stroke with a subtle gradient fill below the line (White to Transparent). Remove all X and Y axis lines; use floating labels for key data points only.
- **Chips/Labels:** Small pill shapes with #141414 background and #8E8E93 text for an understated, metadata look.