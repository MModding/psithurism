package com.mmodding.psithurism.block;

import com.mmodding.library.block.api.catalog.sized.FacingSizedBlock;
import com.mmodding.library.block.api.catalog.sized.SizeManager;

public class MediumTatamiBlock extends FacingSizedBlock {

	public static final SizeManager MANAGER = SizeManager.create(2, 1, 1);

	public MediumTatamiBlock(Properties settings) {
		super(true, settings);
	}

	@Override
	protected SizeManager getSizeManager() {
		return MANAGER;
	}
}
