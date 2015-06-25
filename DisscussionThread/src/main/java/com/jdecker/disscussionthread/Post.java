/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdecker.discussionthread;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import sun.rmi.runtime.Log;

/**
 *
 * @author john
 */
public class Post {
    String topic;
    String User;
    String time;
    String post;
    File content; // for now a string will need to be a file
    /**
     * This is the Non-Default constructor for a Post object.
     * @param topic
     * @param User
     * @param time
     * @param post 
     */
    public Post(String topic, String User, String time, String post) {
        this.topic = topic;
        this.User = User;
        this.time = time;
        this.post = post;
        
        
    }

    /**
     * This is Default Constructor
     */
    public Post() {
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
    
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    // will get information from a file
    public File getFile() {
        return content;
    }

    //This will grab content from the file
    public void setFile(File content) {
        this.content = content;
    }
    
    public List<String> getContents() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(content.getAbsolutePath()), StandardCharsets.UTF_8);
        return lines;
    }
    
    public void setContents(List<String> textBox) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(content.getAbsoluteFile(),true)));
            
            //iteratre through the file
            for(String post : textBox){
            out.println(post);
            out.close();
            }
        } catch (IOException e) {
           //exception error
        }
    }
    
    public List<String> formatPost() {
        
        List<String> format = new ArrayList<String>();
        
        String userTime = "<h2>" + User + " : " + time + "</h2>";
        String topics = "<h3>" + topic + "</h3>";
        String content = "<p>" + post + "</p>";
        
        format.add(userTime + topics + content);
        
        return format;      
    }
}
