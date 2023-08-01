# coding utf-8
import os

from pyspark import SparkConf, SparkContext
# 临时配置环境变量
os.environ['PYSPARK_PYTHON']="D:\\Anaconda2022.10\\envs\\pyspark\\python.exe"

if __name__ == '__main__':
    conf=SparkConf().setMaster("local[*]").setAppName("demo1")
    sc=SparkContext(conf=conf)
    sc.setLogLevel('WARN')
    rdd=sc.textFile("words.txt")
    word_rdd=rdd.flatMap(lambda x: x.split(" ")).map(lambda x:(x,1)).reduceByKey(lambda a,b: a+b)
    result=word_rdd.collect()
    print(result)