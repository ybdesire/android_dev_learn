.class public LHelloWorld;#class
.super Ljava/lang/Object;#super class
.method public static main([Ljava/lang/String;)V#main
    .registers 4    #we need 4 registers
    .prologue       #code begin herer
    #write your code here
    nop
    
    const/16 v0, 0x8
    const/4 v1, 0x5
    const/4 v2, 0x3
    
    move v1, v2
    new-array v0, v0, [I
    array-length v1, v0
    
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V
    
    if-nez v0, :cond_0
    goto :goto_0
    
    :cond_0
    
    int-to-float v2, v2
    
    add-float v2, v2, v2
    
    cmpl-float v0, v2, v2
    
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;
    const-string v1, "Hello World, hahaha"
    
    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V
    
    :goto_0
    
    
    return-void
.end method