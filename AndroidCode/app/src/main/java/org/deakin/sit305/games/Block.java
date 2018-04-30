package org.deakin.sit305.games;

public class Block {

    private int color;

    private Boolean selected;

    private Boolean settled = false;

    private Block left, right, top, bottom, topRight, topLeft, bottomRight,
            bottomLeft;

    private int xLeft;

    private int yTop;

    private int yTopSettle;

    public Block(int color) {

        this.color = color;
        if (color < 0) {
            this.color = color * -1;
        }

        this.selected = false;
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

    public int getColor() {
        return this.color;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected() {
        this.selected = true;
        if (top != null) {
            top.setSelected(color);
        }
        if (bottom != null) {
            bottom.setSelected(color);
        }
        if (left != null) {
            left.setSelected(color);
        }
        if (right != null) {
            right.setSelected(color);
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

    public void setColor(int color) {
        this.color = color;
    }

    public void clearSelection() {
        this.selected = false;

    }

    private void setSelected(int color) {
        if ((!selected) && (this.color == color)) {
            setSelected();
        }
    }

    public boolean isSameColorPair() {

        boolean returnValue = false;

        if (left != null && (this.color == left.getColor())) {
            returnValue = true;
        } else if (right != null
                && (this.color == right.getColor())) {
            returnValue = true;
        } else if (top != null
                && (this.color == top.getColor())) {
            returnValue = true;
        } else if (bottom != null
                && (this.color == bottom.getColor())) {
            returnValue = true;
        }

        return returnValue;
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
        if (yTop <= yTopSettle) {
            this.yTop = yTop;
        } else {
            yTop = yTopSettle;
            settled = true;
        }
    }

    public int getyTopSettle() {
        return yTopSettle;
    }

    public void setyTopSettle(int yTopSettle) {
        this.yTopSettle = yTopSettle;
    }

    public Boolean getSettled() {
        return settled;
    }

    public void setSettled(Boolean settled) {
        this.settled = settled;
    }
}
