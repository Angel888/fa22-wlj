package PlusWorld;

import org.junit.Test;

import static org.junit.Assert.*;

import byowTools.TileEngine.TERenderer;
import byowTools.TileEngine.TETile;
import byowTools.TileEngine.Tileset;

import java.util.List;
import java.util.Random;

/**
 * Draws a world consisting of plus shaped regions.
 */
//todo 0 创造一个empty world 1 先画一个➕ or 3 rows
// 2 铺满整个屏幕
public class PlusWorld {
    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;


    //todo
    // s 是➕的宽度
    public static void addPlus(int s, int heng, int shu, TETile[][] world, int startX, int startY) {
        // 先画竖线 startX 和 startY 代表竖线的左下角
        for (int x = startX; x < 2 + startX; x += 1) {
            for (int y = startY; y < shu + startY; y += 1) {
                world[x][y] = Tileset.PLUS;
            }
        }
        // 横线的起始位置
        int hengStartY=startY+ shu /2-1;
        int hengStartX=startX-1 - (int) heng /2;
        System.out.printf("hengStartX:%d,hengStartY:%d\n",hengStartX,hengStartY);
        for (int x = hengStartX; x < heng + startX; x += 1) {
            for (int y = hengStartY; y < hengStartY+2; y += 1) {
                world[x][y] = Tileset.PLUS;
            }
        }

    }

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }
        int[] rowSize = new int[2];
        rowSize[0] = 5;
        rowSize[1] = 8;


        addPlus(2, 6, 8, world, 10, 10);
        ter.renderFrame(world);
        // todo 想要重复的话我理解写个双层的循环就可以了呀 可以看看proj3
    }
}
