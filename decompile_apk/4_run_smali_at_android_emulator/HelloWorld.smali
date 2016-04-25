.class public LHelloWorld;#class
.super Ljava/lang/Object;#super class
.method public static main([Ljava/lang/String;)V#main
    .registers 3    #we need 4 registers
    .prologue       #code begin herer
    #write your code here

    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;
    const-string v1, "Hello World, hohohohoho"
    
    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V
    
    :goto_0
    
    
    return-void
.end method