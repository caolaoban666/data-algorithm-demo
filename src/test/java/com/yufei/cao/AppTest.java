package com.yufei.cao;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    public static Random rand = new Random(47);


    public static void main(String[] args) {

        Class initable =  Initable.class;
        System.out.println("After creating Initable ref");
        System.out.println(Initable.staticFinal);
        System.out.println(Initable.staticFinal2);

    }


    static class Initable{
        static final int staticFinal = 147;
        static final int staticFinal2 = AppTest.rand.nextInt(1000);
        static {
            System.out.println("Initializing Initable");
        }
    }

    static class Initable2{
        static int staticNonFinal = 47;
        static {
            System.out.println("Initializing Initable2");
        }
    }

    static class Initable3{
        static int staticNonFinal = 74;
        static {
            System.out.println("Initializing Initable3");
        }
    }








}
