# coding utf-8
from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StringType, IntegerType

if __name__ == '__main__':
	spark = SparkSession.builder.appName('sparkinhive').master('local[*]') \
		.config('spark.sql.warehouse.dir', 'hdfs://node1:8020/user/hive/warehouse') \
		.config('hive.metastore.uris', 'thrift://node1:9083').enableHiveSupport().getOrCreate()

	schema = StructType().add("name", StringType()) \
		.add('age', IntegerType()) \
		.add("id", StringType())

	df = spark.read.format('csv') \
		.option('sep', ';') \
		.option('encoding', 'utf-8') \
		.option('header', False) \
		.schema(schema=schema) \
		.load('./student.csv')
	df.printSchema()
	df.show()
	# # 写入node1的mysql中
	# df.write.mode('overwrite') \
	# 	.format('jdbc') \
	# 	.option('url', 'jdbc:mysql://node1:3306/test?useSSl=false&useUnicode=true') \
	# 	.option('dbtable', 'student') \
	# 	.option('user', 'root') \
	# 	.option('password', 'hadoop') \
	# 	.save()

	# # 写入node1的hive中
	# df.write.mode('overwrite').format('jdbc') \
	# 	.option('url', 'jdbc:hive2://node1:10000/itheima?useSSl=false&useUnicode=true') \
	# 	.option('dbtable','student').option('user','root').option('password','hadoop') \
	# 	.save()

	df.write.saveAsTable('itheima.student',None,'overwrite',None)