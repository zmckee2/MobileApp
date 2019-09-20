package com.example.cpsc321; //Must be first executable line

import com.mckee.zach.Zach;

public class Main {
    public static void main(String[] args) {
        // Package is a grouping of related types
        // Why use a package?
        // organization
        // namespace management
        // access control

        System.out.println(String.class.getPackage());
        System.out.println(Main.class.getPackage());
        System.out.println(Zach.class.getPackage());
    }
}
