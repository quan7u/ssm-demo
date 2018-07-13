package po;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page<T> {

	private int pageNo = 1;
	private int pageSize = 2;//最大记录数
	private int totalRecord;// 总记录数
	private int totalPage;//总页数
	private List<T> results;//查询结果
	private Map<String, Object> params = new HashMap<String, Object>();

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		// 设置总记录数数的时候计算出对应的总页数
		int totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize : totalRecord / pageSize + 1;
		this.setTotalPage(totalPage);
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

}
