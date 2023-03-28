package com.lab.services;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Database {

    InputStreamReader reader = new InputStreamReader(
            new FileInputStream("../../../resources/database.txt"), StandardCharsets.UTF_8);

    BufferedReader bufReader = new BufferedReader(reader);
    OutputStreamWriter writer = new OutputStreamWriter(
            new FileOutputStream("../../../resources/database.txt"), StandardCharsets.UTF_8);

    BufferedWriter bufWriter = new BufferedWriter(writer);

    Database() throws IOException {
        readFromBase();
    }

    private void readFromBase() {

    }

    public void writeToBase() {}
}
