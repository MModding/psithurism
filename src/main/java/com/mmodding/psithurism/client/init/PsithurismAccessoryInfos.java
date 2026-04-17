package com.mmodding.psithurism.client.init;

import com.mmodding.library.rendering.api.AccessoryInfo;
import com.mmodding.psithurism.Psithurism;
import com.mmodding.psithurism.client.model.KitsuneMaskModel;
import com.mmodding.psithurism.client.model.OniMaskModel;

public class PsithurismAccessoryInfos {

	public static final AccessoryInfo KITSUNE = AccessoryInfo.create(KitsuneMaskModel::new, Psithurism.createTexture("mask/kitsune"));
	public static final AccessoryInfo ONI = AccessoryInfo.create(OniMaskModel::new, Psithurism.createTexture("mask/oni"));
}
