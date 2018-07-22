function loadTwoLine() {
	    var myChart = echarts.init(document.getElementById('TwoLineChart'));
	    // 显示标题，图例和空的坐标轴
	    myChart.setOption({
	        title: {
	            text: '时间流量趋势图'
	        },
	        tooltip: {
	            trigger: 'axis'
	        },
	        legend: {
	            data: ['日流量趋势图']
	        },
	        toolbox: {
	            show: true,
	            feature: {
	                mark: { show: true },
	                dataView: { show: true, readOnly: false },
	                magicType: { show: true, type: ['line', 'bar'] },
	                restore: { show: true },
	                saveAsImage: { show: true }
	            }
	        },
	        calculable: true,
	        xAxis: {
	            type: 'category',
	            boundaryGap: false, //取消左侧的间距
	            data: []
	        },
	        yAxis: {
	            type: 'value',
	            splitLine: { show: false },//去除网格线
	            name: ''
	        },
	        series: [{
	            name: '日流量趋势图',
	            type: 'line',
	            markPoint: {
		            data: [
			            {type: 'max', name: '最大值'},
			            {type: 'min', name: '最小值'}
		            ]
		        },
		        markLine: {	
			        data: [
			            {type: 'average', name: '平均值'}
			        ]
			    },
	            symbol: 'emptydiamond',    //设置折线图中表示每个坐标点的符号 emptycircle：空心圆；emptyrect：空心矩形；circle：实心圆；emptydiamond：菱形
	            data: []
	        }]
	    });
	    myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画
	    var datetimes = [];    //类别数组（实际用来盛放X轴坐标值）    
	    var flows = [];
	    $.ajax({
	        type: 'get',
	        url: 'http://localhost:8080/api/timeflow',//请求数据的地址
	        dataType: "json",        //返回数据形式为json
	        success: function (result) {
//	        	alert(result.itemId)
//	        	console.info(result.itemId);
	            //请求成功时执行该函数内容，result即为服务器返回的json对象           
	            $.each(result.list, function (index, item) {
	                datetimes.push(item.datetime);    //挨个取出类别并填入类别数组
	                flows.push(item.flow);
	            });  
	            myChart.hideLoading();    //隐藏加载动画
	            myChart.setOption({ 
	            	//加载数据图表
	                title:{
	                	text: "每日流量趋势图"
	                },
	                xAxis: {
	                    data: datetimes
	                },
	                yAxis:{},
	                series: [{                    
	                    data: flows
	                }]
	            });
	        },
	        error: function (errorMsg) {
	            //请求失败时执行该函数
	            alert("图表请求数据失败!");
	            myChart.hideLoading();
	        }
	    });
	};
	loadTwoLine();