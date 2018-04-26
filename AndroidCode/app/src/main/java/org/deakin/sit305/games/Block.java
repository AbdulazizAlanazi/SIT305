package org.deakin.sit305.games;

public class Block {

    private Block left, right, top, bottom, topRight, topLeft, bottomRight,
            bottomLeft;

    private int xLeft;
    private int yTop;

    private int color;

    private boolean selected;

    public Block(int color) {
        this.selected = false;
        this.color = color;
        if (this.color < 0) {
            this.color = this.color * -1;
        }
    }

    public void setTop(Block top) {
        this.top = top;
        if (top != null) {
            top.setBottom(this);
        }
    }

    public void setTopRight(Block topRight) {

        this.topRight = topRight;
        if (topRight != null) {
            topRight.setBottomLeft(this);
        }
    }

    public void setRight(Block right) {
        this.right = right;
        if (right != null) {
            right.setLeft(this);
        }
    }

    public void setBottomRight(Block bottomRight) {
        this.bottomRight = bottomRight;
        if (bottomRight != null) {
            bottomRight.setTopLeft(this);
        }
    }

    public Block getLeft() {
        return left;
    }

    public void setLeft(Block left) {
        this.left = left;
    }

    public Block getRight() {
        return right;
    }

    public Block getTop() {
        return top;
    }

    public Block getBottom() {
        return bottom;
    }

    public void setBottom(Block bottom) {
        this.bottom = bottom;
    }

    public Block getTopRight() {
        return topRight;
    }

    public Block getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Block topLeft) {
        this.topLeft = topLeft;
    }

    public Block getBottomRight() {
        return bottomRight;
    }

    public Block getBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(Block bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public int getxLeft() {
        return xLeft;
    }

    public void setxLeft(int xLeft) {
        this.xLeft = xLeft;
    }

    public int getyTop() {
        return yTop;
    }

    public void setyTop(int yTop) {
            this.yTop = yTop;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected() {
        this.selected = true;
    }

}
