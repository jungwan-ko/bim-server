package com.web.base.open.rss.service;

import java.util.List;

import com.web.base.open.dto.WetherRssDto;

public interface IWetherRssService {
	public List<WetherRssDto> list(String paramAdmCode);
}
