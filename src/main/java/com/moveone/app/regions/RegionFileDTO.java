package com.moveone.app.regions;

import com.moveone.app.files.FileDTO;

public class RegionFileDTO extends FileDTO {
	private Long region_id;

	public Long getRegion_id() {
		return region_id;
	}

	public void setRegion_id(Long region_id) {
		this.region_id = region_id;
	}
}
