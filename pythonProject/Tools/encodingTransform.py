import csv
import codecs
import os


def convert_encoding(input_file, output_file, input_encoding='gbk', output_encoding='utf-8'):
	with codecs.open(input_file, 'r', encoding=input_encoding) as f_in:
		with codecs.open(output_file, 'w', encoding=output_encoding) as f_out:
			reader = csv.reader(f_in)
			writer = csv.writer(f_out)
			for row in reader:
				writer.writerow(row)


if __name__ == '__main__':
	# 指定输入文件和输出文件的路径
	input_folder='data1'
	output_folder='data2'
	# 获取data1文件夹下的所有CSV文件
	csv_files=[file for file in os.listdir(input_folder) if file.endswith('.csv')]
	for csv_file in csv_files:
		input_file=os.path.join(input_folder,csv_file)
		output_file=os.path.join(output_folder,csv_file)
		# 调用函数进行编码转换
		convert_encoding(input_file,output_file)