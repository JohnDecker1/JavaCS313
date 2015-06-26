/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdecker.disscussionthread;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;

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
     * @param post 
     */
    public Post(String topic, String User, String post) {
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        
        this.topic = topic;
        this.User = User;
        this.time = dateFormat.format(cal.getTime());
        this.post = post;
        this.content = new File("postInfo.txt");
       try {
            
            if (!(this.content.createNewFile())){
                PrintWriter printWriter = new PrintWriter ("postError.txt");
                printWriter.println("did not create file");
            }
        } catch (IOException ex) {
            Logger.getLogger(Post.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    /**
     * This is Default Constructor
     */
    public Post() {
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        
        this.topic = "Untitled";
        this.User = "ANON";
        this.time = dateFormat.format(cal.getTime());
        this.post = "The Salted Pork is especally tasty.";
        this.content = new File("postInfo.txt");
        try {
            
            if (!(this.content.createNewFile())){
                PrintWriter printWriter = new PrintWriter ("postError.txt");
                printWriter.println("did not create file");
            }
        } catch (IOException ex) {
            Logger.getLogger(Post.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(content.getAbsolutePath(),true)));
            
            //iteratre through the file
            for(String temp : textBox){
            out.println(temp);
            out.close();
            }
        } catch (IOException e) {
           //exception error
        }
    }
    
    public List<String> formatPost() {
        
        List<String> format = new ArrayList<String>();
        
        String userTime = "<div class=\"post\"><p id=\"author\">Post by " + User + " : " + time + "</p>";
        String topics = "<h3 class=\"topic\">" + topic + "</h3>";
        String thread = "<p class=\"main\">" + post + "</p></div>";
        
        format.add(userTime + topics + thread);
        
        return format;      
    }
}
