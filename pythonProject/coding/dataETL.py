from pyspark.sql import functions as F

from Tools.tools import *

if __name__ == '__main__':
	spark = getSparkSessionOnHive('ETL')

	# 展示源数据
	df = spark.sql("select city, `date`, max_deg, min_deg, weather, wind from project.source")
	# df.show(10)

	# 过滤存在空值的行数据
	# col_names = df.columns
	# for col in col_names:
	# 	df.where(F.col(col).isNull()).show()
	df1 = df.dropna("any")

	# 分割date和wind
	df1 = df1.withColumn('year', F.split(F.col('`date`'), '-')[0].cast('int'))
	df1 = df1.withColumn('month', F.split(F.col('`date`'), '-')[1].cast('int'))
	df1 = df1.withColumn('day', F.split(F.col('`date`'), '-')[2].cast('int'))
	df1 = df1.withColumn('wind_dir', F.split(F.col('wind'), ' ')[0])
	df1 = df1.withColumn('wind_power', F.split(F.col('wind'), ' ')[1])
	df2 = df1.select('city', 'year', 'month', 'day', 'max_deg', 'min_deg', 'weather', 'wind_dir', 'wind_power')
	# df2.show(10)
	# df2.printSchema()

	# 将DataFrame保存到Hive表中
	# writeToHive(df2, 'source_ETL')

	# spark.sql("select * from project.source_ETL limit 10").show()
	spark.sql("desc formatted project.source_ETL").show()
	spark.sql("desc formatted project.source").show()
