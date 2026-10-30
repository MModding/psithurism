package com.mmodding.psithurism.block;

import com.mmodding.library.block.api.catalog.sized.FacingSizedBlock;
import com.mmodding.library.block.api.catalog.sized.SizeManager;

public class LargeTatamiBlock extends FacingSizedBlock {

	public static final SizeManager MANAGER = SizeManager.create(2, 1, 2);

	public LargeTatamiBlock(Properties settings) {
		super(true, settings);
	}

	@Override
	protected SizeManager getSizeManager() {
		return MANAGER;
	}
}
