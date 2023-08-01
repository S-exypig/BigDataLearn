# coding:utf8
from pyspark.sql.types import StructType, StringType, IntegerType

from Tools.tools import *


if __name__ == '__main__':
	spark = getSparkSessionOnHive('data_to_hive')
	# 设置模式
	schema = StructType() \
		.add('city', StringType()) \
		.add('date', StringType()) \
		.add('max_deg', IntegerType()) \
		.add('min_deg', IntegerType()) \
		.add('weather', StringType()) \
		.add('wind', StringType())
	# 读取数据
	df1 = spark.read.format('csv').option('header', 'false').option('sep', ',').schema(schema).load(
		'../data/chongqing.csv')
	df2 = spark.read.format('csv').option('header', 'false').option('sep', ',').schema(schema).load(
		'../data/guangzhou.csv')
	df3 = spark.read.format('csv').option('header', 'false').option('sep', ',').schema(schema).load(
		'../data/haerbin.csv')
	df4 = spark.read.format('csv').option('header', 'false').option('sep', ',').schema(schema).load('../data/lasa.csv')
	df5 = spark.read.format('csv').option('header', 'false').option('sep', ',').schema(schema).load(
		'../data/shanghai.csv')
	df6 = spark.read.format('csv').option('header', 'false').option('sep', ',').schema(schema).load(
		'../data/shenyang.csv')
	df7 = spark.read.format('csv').option('header', 'false').option('sep', ',').schema(schema).load(
		'../data/tianjin.csv')
	df8 = spark.read.format('csv').option('header', 'false').option('sep', ',').schema(schema).load(
		'../data/wulumuqi.csv')
	# for df in dfs:
	# 	df.show(5)
	# 将数据合并成一个df
	df = df1.union(df2).union(df3).union(df4).union(df5).union(df6).union(df7).union(df8)
	df.show(5)
	# 写入hive中，表名为source
	writeToHive(df, 'source')
	# 查看是否成功写入
	result = spark.sql('select * from project.source limit 10')
	result.show()
	# 关闭spark
	spark.stop()

