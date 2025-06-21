# Class Design Document

## Table of Contents

## Decisions till now (To be refined)
Each shape should contain minimum information for it to be rendered.

**Example:**
For a line the defining feature is it's start and end coordinate. No need to calculate all intermediate points. Just calculate intermediate **integer interval** points

## Shape
Each shape is a geometric entity residing on 2D graphical surface i.e., the **Monitor**. As ASCII frame to be rendered instead of storing **points** it stores **pixels** which inturn stores the style information i.e., which character to be rendered in place of it.

Add a movable Shape interface to indicate that a shape is movable. It will be helpful during animation as animation should not care about specific type of shape to move it.

<!-- TODO: Check the design -->