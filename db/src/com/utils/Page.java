/**
 * 
 */
package com.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * FileName: Page.java
 * 
 * The Page class is use for pagination.
 * 
 * @author Marc Heruela
 * @version 1.00
 * 
 * @see
 * @since 1.00
 *
 * <pre>
 * #############################################################################
 * Date           Modified By          Description
 * #############################################################################
 *
 * Aug 17, 2010   Marc Heruela              Initial code.
 *  
 * </pre>
 */
public class Page<T> {

	private List<T> contents; //-- the actual list
	private Integer currentPage; //-- the current page number of this list
	private Integer currentSize; //-- the current size of data
	private Integer size; //-- the maximum size per page
	private Integer totalPages; //-- the total number of pages
	private Integer totalSize; //-- the total number of data
	private BigDecimal totalAmount[];//sum of the numeric column of the resultSet
	
	public Page(List<T> contents, Integer currentPage, Integer totalSize, Integer size) {
		this.contents = contents;
		this.currentSize = contents==null ? 0 : contents.size();
		this.currentPage = currentPage;
		this.totalSize = totalSize;
		this.size = size;
		this.totalPages = (this.totalSize==null || this.size==null|| this.totalSize == 0)?0: ((Double) Math.ceil(this.totalSize.doubleValue() / this.size.doubleValue())).intValue();
	}
	
	public Page(List<T> contents, Integer currentPage, BigDecimal totalAmount[], Integer totalSize, Integer size) {
		this.contents = contents;
		this.currentSize = contents==null ? 0 : contents.size();
		this.currentPage = currentPage;
		this.totalAmount = totalAmount;
		this.totalSize = totalSize;
		this.size = size;
		
		this.totalPages = (this.totalSize==null || this.size==null || this.totalSize != 0)?0: ((Double) Math.ceil(this.totalSize.doubleValue() / this.size.doubleValue())).intValue();
	}	

	public List<T> getContents() {
		return contents;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public Integer getCurrentSize() {
		return currentSize;
	}
	
	public Integer getSize() {
		return size;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public Integer getTotalSize() {
		return totalSize;
	}

	public void setContents(List<T> contents) {
		this.contents = contents;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setCurrentSize(Integer currentSize) {
		this.currentSize = currentSize;
	}
	
	public void setSize(Integer size) {
		this.size = size;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}	

	public BigDecimal[] getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal[] totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<Integer> getPages() {
		List<Integer> pages = new ArrayList<Integer>();
		
		for(int i = 1; i <= this.totalPages; i++) {
			pages.add(i);
		}
		
		return pages;
	}
}