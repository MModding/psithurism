package com.mmodding.psithurism.client.init;

import com.mmodding.library.rendering.api.AccessoryInfo;
import com.mmodding.psithurism.Psithurism;
import com.mmodding.psithurism.client.model.KitsuneMaskModel;
import com.mmodding.psithurism.client.model.OniMaskModel;

public class PsithurismAccessoryInfos {

	public static final AccessoryInfo KITSUNE = AccessoryInfo.create(KitsuneMaskModel::normal, Psithurism.createTexture("mask/kitsune"));
	public static final AccessoryInfo WORN_KITSUNE = AccessoryInfo.create(KitsuneMaskModel::worn, Psithurism.createTexture("mask/kitsune"));

	public static final AccessoryInfo ONI = AccessoryInfo.create(OniMaskModel::normal, Psithurism.createTexture("mask/oni"));
	public static final AccessoryInfo WORN_ONI = AccessoryInfo.create(OniMaskModel::worn, Psithurism.createTexture("mask/oni"));
}
