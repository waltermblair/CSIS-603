package edu.citadel.csci603.util;

import java.io.*;

/**
 * Utility class that prints the directory structure to standard output
 * showing the composition of nested files and subdirectories.
 */
public class PrintDirectoryStructure {
    /**
     * Prints the structure for the file whose path name is given in arg[0].
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            printUsage();
            System.exit(-1);
        }

        String pathName = args[0];
        File file = new File(pathName);

        if (file.exists())
            printTree(file);
        else
            System.out.println("*** File " + pathName + " does not exist. ***");
    }

    public static void printTree(File file) {
        System.out.println(file.getPath());
        if(file.isFile())
            printFile(file, -1);
        else
            printDirectory(file, -1);
    }

    private static void printDirectory(File dir, int nestingLevel) {
        System.out.println(getIndentString(++nestingLevel) + "+ " + dir.getName());
        for (File f : dir.listFiles()) {
            if(f.isFile())
                printFile(f, nestingLevel);
            else
                printDirectory(f, nestingLevel);
        }
    }

    private static void printFile(File file, int nestingLevel) {
        System.out.println(getIndentString(++nestingLevel) + "- " + file.getName());
    }

    private static String getIndentString(int nestingLevel) {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < nestingLevel; i++)
            s.append("  ");

        return s.toString();
    }

    private static void printUsage() {
        System.out.println("Usage: edu.citadel.csis603.(<path>)");
        System.out.println("    where <path> is the path of a file or directory");
        System.out.println();
    }
}
