import pyspark.sql.dataframe
from pyspark.sql import SparkSession

def getSparkSessionOnHive(app_name: str):
	spark = SparkSession.builder \
		.appName(app_name) \
		.master('local[*]') \
		.config('spark.sql.shuffle.partitions', '2') \
		.config('spark.sql.warehouse.dir', 'hdfs://node1:8020/user/hive/warehouse') \
		.config('hive.metastore.uris', 'thrift://node1:9083') \
		.enableHiveSupport() \
		.getOrCreate()
	return spark


def getSparkSession(app_name: str):
	spark = SparkSession.builder \
		.appName(app_name) \
		.master('local[*]') \
		.config('spark.sql.shuffle.partitions', '2') \
		.getOrCreate()
	return spark


def writeToHive(df: pyspark.sql.dataframe.DataFrame, table_name: str, mode: str = 'overwrite'):
	df.write.mode(mode).saveAsTable('project.' + table_name, 'parquet')


def createTable(table_name: str, schema: str):
	getSparkSessionOnHive('default').sql(f"CREATE TABLE if not exists {table_name} ({schema})")
