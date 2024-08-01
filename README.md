## Elegant Programming (优雅的编程)

## 写在前面：



Elegant Programming 是分享如何将代码写的更加优雅，代码不仅是程序运行的，更是人读的。既然是人读的，那么我就应该让它可读性更强一点。这个项目中所有的案例都是我平时工作中的积累，也没有刻意想要系统化的整理这种编程技巧，也是想到点就写一点。但是我保证你一定能有所收获。



## 什么让我鼓起勇气写这个？


首先现在这个大环境，大家都执着于“八股文”，主要这东西和工资挂钩啊，面的好才能拿高薪，当然这一点是无可厚非的，但是除了理论知识外，我还是希望在行业中能够让编码的能力和技巧也成为考核的一方面，由于技巧很难在面试中体现，导致大家都忽视了它。



## 如何学习？

````
-- common                       （这里主要是辅助案例的代码，本身不重要，可以不用关注）

-- casen                        （这里是案例）

---- main                       （这里固定是有两个类，分别是 ExampleHandler 和 GraceExampleHandler）

------ ExampleHandler.java      （这个是错误的案例，这是重点！！！）

------ GraceExampleHandler.java （这个是正确的案例，这是重点！！！）

---- XXXExample.java            （这个是入口的类，这里面我会解释案例，这是重点！！！）
````

**喜欢的同学就点个 star 吧，谢谢。**


## 例子

错误的写法
````
// 主要看这段代码，可以思考一下这种情况如何让可读性更强
if (Objects.isNull(hostNo)) {
    if (!isOpenAutoRegister) {
        return DEFAULT_NO;
    } else {
        // 这里是注册主机的编号，由于案例请忽略分布式线程安全问题
        return registerHostNo(hostNoKey);
    }
} else {
    return Integer.parseInt(String.valueOf(hostNo));
}

````

优雅的写法
````
// 主要看这段代码，下面的写法更加优雅，仅用了三行代码
if (Objects.nonNull(hostNo)) {
    return Integer.parseInt(String.valueOf(hostNo));
}

return isOpenAutoRegister ? registerHostNo(hostNoKey) : DEFAULT_NO;
````

## 目录


<a href="https://github.com/pydlove/ElegantProgramming/blob/master/src/main/java/com/pany/camp/example/case1/ExceptionExample.java">**1、Case1:** 如何优雅地捕获很多异常？</a>

<a href="https://github.com/pydlove/ElegantProgramming/blob/master/src/main/java/com/pany/camp/example/case2/CallbackExample.java">**1、Case2:** 如何巧妙的利用 Callback 来让业务更加纯粹？</a>

<a href="https://github.com/pydlove/ElegantProgramming/blob/master/src/main/java/com/pany/camp/example/case3/ThreadPoolExample.java">**1、Case3:** 线程池如何优雅的保护内存，如何优雅的统一管理？ </a>

<a href="https://github.com/pydlove/ElegantProgramming/blob/master/src/main/java/com/pany/camp/example/case4/ParamExample.java">**1、Case4:** 用返回代替传参会更加优雅 </a>

<a href="https://github.com/pydlove/ElegantProgramming/blob/master/src/main/java/com/pany/camp/example/case5/IfElseExample.java">**1、Case5:** 如何让 if-else 的代码更加优雅？ </a>



## License


<a href="https://github.com/pydlove/ElegantProgramming/blob/master/LICENSE">BSD 3-Clause License</a>
