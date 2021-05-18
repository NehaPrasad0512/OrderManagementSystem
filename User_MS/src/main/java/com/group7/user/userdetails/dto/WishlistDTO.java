package com.group7.user.userdetails.dto;

import com.group7.user.userdetails.entity.CompositeTable;
import com.group7.user.userdetails.entity.Wishlist;

public class WishlistDTO {

	private String buyerId;
	private String prodId;
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	
	//conversion of entity to dto
//	public static WishlistDTO valueOf(Wishlist wish) {
//		WishlistDTO wDTO=new WishlistDTO();
//		ProductDTO pDTO=new ProductDTO();
//		pDTO.setProdID(wish.getCompositeId().getProdId());
//		wDTO.setProductIdDetail(pDTO);
//		return wDTO;
//	}
	
	//Convert dto into entity
	public static Wishlist createEntity() {
		Wishlist w=new Wishlist();
		CompositeTable val=new CompositeTable();
		val.setProdId(w.getCompositeId().getProdId());
		w.setCompositeId(val);
		return w;
	}

}
