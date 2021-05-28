package com.web.base.open.viewmodel;

import java.util.List;

import com.web.base.BaseViewModel;
import com.web.base.open.dto.WetherRssDto;

public class WetherViewModel extends BaseViewModel {
	public List<WetherRssDto> listWetherRss;
	public WetherRssDto detailWetherRss;
	
	public List<WetherRssDto> getListWetherRss() {
		return listWetherRss;
	}
	public void setListWetherRss(List<WetherRssDto> listWetherRss) {
		this.listWetherRss = listWetherRss;
	}
	public WetherRssDto getDetailWetherRss() {
		return detailWetherRss;
	}
	public void setDetailWetherRss(WetherRssDto detailWetherRss) {
		this.detailWetherRss = detailWetherRss;
	}
	
	
}
