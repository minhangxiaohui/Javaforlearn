package fordecodegesila;
//package guoweiforcrypto;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

//import org.bouncycastle.util.encoders.Base64Encoder;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;
//import sun.misc.BASE64Decoder;

/**
 *
 * @author Administrator
 *
 */
public class AEStest {

    // 加密
    public static String Encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));

        return Base64.getEncoder().encodeToString(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    // 解密
    public static String Decrypt(String sSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
//            BASE64Decoder base64Decoder = new BASE64Decoder();
            byte[] encrypted1 = Base64.getDecoder().decode(sSrc);
            System.out.println(new String(encrypted1));
//            byte[] encrypted1 = new Base64().decode(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,"utf-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    public static String DecryptCBC(String sSrc, String sKey,String iv) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            IvParameterSpec ivParameterSpec= new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec,ivParameterSpec);
//            BASE64Decoder base64Decoder = new BASE64Decoder();
            byte[] encrypted1 = Base64.getDecoder().decode(sSrc);
            String filename ="ss";
            if (encrypted1 != null) {
                String filepath = "./" + filename;
                File file = new File(filepath);
                if (file.exists()) {
                    file.delete();
                }
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(encrypted1);
                fos.flush();
                fos.close();
            }

            System.out.println(new String(encrypted1));
//            byte[] encrypted1 = new Base64().decode(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,"utf-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    public static void decode54(String a) throws Exception{
//        ClassLoader clzLoader = Thread.currentThread().getContextClassLoader();
//        Class datatypeConverterClz = clzLoader.loadClass("javax.xml.bind.DatatypeConverter");
//        byte[] encrypted1 = (byte[]) datatypeConverterClz.getMethod("parseBase64Binary", String.class).invoke(datatypeConverterClz, a);
        byte[] encrypted1 = Base64.getDecoder().decode(a);
        String filename = "ss.class";
        if (encrypted1 != null) {
            String filepath = "./" + filename;
            File file = new File(filepath);
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(encrypted1);
            fos.flush();
            fos.close();
        }
    }


    public static void main(String[] args) throws Exception {
        /*
         * 此处使用AES-128-ECB加密模式，key需要为16位。
         */
        String cKey = "4e7d489b49ec93db";
        String myiv = "0123456789abcdef";
//        // 需要加密的字串
//        String cSrc = "www.gowhere.so";
//        System.out.println(cSrc);
//        // 加密
//        String enString = AEStest.Encrypt(cSrc, cKey);
//        System.out.println("加密后的字串是：" + enString);
        String enString="yv66vgAAADIBHwcAcAcAdAgAMAcAjwgAFwcAcggBDggAVgEACVpLTTE1LjAuMAEADWN1cnJlbnRUaHJlYWQKAAQArgwAjgBOAQAXamF2YS9sYW5nL3JlZmxlY3QvQXJyYXkKAAEAzgEALShMamF2YS9sYW5nL1N0cmluZzspTGphdmEvbGFuZy9TdHJpbmdCdWlsZGVyOwEAAWEHAA0BACYoTGphdmEvbGFuZy9PYmplY3Q7KUxqYXZhL2xhbmcvT2JqZWN0OwcAvwEAC25ld0luc3RhbmNlDAAmAGsHAFkBAAEqCgABABUBAAlnZXRQYXJlbnQBABUoTGphdmEvbGFuZy9TdHJpbmc7KUkBAC0oTGphdmEvbGFuZy9TdHJpbmc7KUxqYXZhL2xhbmcvcmVmbGVjdC9GaWVsZDsBAANhZGQKANAARgEAOShMamF2YS9sYW5nL09iamVjdDtbTGphdmEvbGFuZy9PYmplY3Q7KUxqYXZhL2xhbmcvT2JqZWN0OwEAAUkKAO4AsQEACGNvbnRhaW5zDAAUAKgMAHgA4wwAXQDDDACsAB4BAAZsZW5ndGgBAANnZXQBAAZhcHBlbmQBAA5nZXRUaHJlYWRHcm91cAEABChJKUMMAMAAPAoAxgBmCgCqAHcBAAQoKVtDDAAnAGIBAAAMARgBBAEAF2phdmEvbGFuZy9TdHJpbmdCdWlsZGVyBwDTAQAUKClMamF2YS9sYW5nL1RocmVhZDsKAPwAIgEAFWphdmEvbGFuZy9DbGFzc0xvYWRlcgwA2gClCgBSADcMAKYASwEAJyhbTGphdmEvbGFuZy9PYmplY3Q7KUxqYXZhL2xhbmcvT2JqZWN0OwEAFShJKUxqYXZhL2xhbmcvU3RyaW5nOwEAECgpTGphdmEvbmV0L1VSTDsKAAEAugoAqgEBAQAVKExqYXZhL2xhbmcvT2JqZWN0OylaCgAWACUMAQMAGgEABmV4aXN0cwwA/wA7AQAGaW50ZXJuCgABAGwMAO8AqAEADWNyZWF0ZU5ld0ZpbGUBABVnZXRDb250ZXh0Q2xhc3NMb2FkZXIBABFqYXZhL2xhbmcvUGFja2FnZQEACWdldE1ldGhvZAEABShbQylWAQAZKClMamF2YS9sYW5nL0NsYXNzTG9hZGVyOwcBBwEAKChMamF2YS9sYW5nL09iamVj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CgABAOQBABUoSSlMamF2YS9sYW5nL09iamVjdDsKAPwAigoAxwCzAQAWKElJKUxqYXZhL2xhbmcvU3RyaW5nOwwAFAA6AQAZKClMamF2YS9sYW5nL1RocmVhZEdyb3VwOwoAAQEZAQARTGphdmEvbGFuZy9DbGFzczsKAI0AsQEAAygpSQwA7QAqCgBSAJIKARMAlQEABXRvVVJJAQAQamF2YS9sYW5nL1N0cmluZwEAFihDQylMamF2YS9sYW5nL1N0cmluZzsBAAxqYXZhL25ldC9VUkwKAPwA5gEAAltCBwC8CgDQAC8MABkATAEAA3B1dAwApgBbAQANU3RhY2tNYXBUYWJsZQoAxwC7AQAGYS5qYXZhDABIAEwBAA9qYXZhL2xhbmcvQ2xhc3MBAARUWVBFAQAHcmVwbGFjZQwAfwBpCgARAAwHAOwMAI4A8wwA3QCyCgABADkKAE0AQQoAgwArAQANZ2V0U3VwZXJjbGFzcwwBBgChAQAIZ2V0Q2xhc3MBAARDb2RlBwBYAQADc2V0AQAXamF2YS9sYW5nL3JlZmxlY3QvRmllbGQBAAQoWilWAQAKU291cmNlRmlsZQwAiwDFAQACW0MHAQAMAKYA9AEAQChMamF2YS9sYW5nL1N0cmluZztbTGphdmEvbGFuZy9DbGFzczspTGphdmEvbGFuZy9yZWZsZWN0L01ldGhvZDsMALkAawEAEGphdmEvbGFuZy9PYmplY3QMAKMAlgEAFShMamF2YS9sYW5nL1N0cmluZzspVgcBHAEAHWphdmEvbGFuZy9yZWZsZWN0L0NvbnN0cnVjdG9yCgABAMoKAE0AwgoABACEAQALdG9DaGFyQXJyYXkBABUoKUxqYXZhL2xhbmcvUGFja2FnZTsKAI0AWgEAEWdldERlY2xhcmVkTWV0aG9kBwEFAQAUKClMamF2YS9sYW5nL1N0cmluZzsBAAY8aW5pdD4KARMAVAEAFCgpTGphdmEvbGFuZy9PYmplY3Q7CgCNAP0HADYKAMcA9wEABmludm9rZQoAxwESDAAnABIMAEoAlgEAJShMamF2YS9sYW5nL1N0cmluZzspTGphdmEvbGFuZy9DbGFzczsMAQ0ApQEAJihMamF2YS9sYW5nL1N0cmluZzspTGphdmEvbGFuZy9TdHJpbmc7DACmAJoBAAZlcXVhbHMKAAEA1wEAEGdldERlY2xhcmVkRmllbGQMAEQApQwA9QDbAQAEc2l6ZQwAIQDyDABCAMMBAB5qYXZhL2xhbmcvTm9TdWNoRmllbGRFeGNlcHRpb24KAMYA+AwAHAA/AQAgamF2YS9sYW5nL0NsYXNzTm90Rm91bmRFeGNlcHRpb24BAAV0b1VSTAcAywwAyQBgAQADKClaCgDHAM0BABMoKUxqYXZhL2xhbmcvQ2xhc3M7BwCcBwEVAQABYgEAB3ZhbHVlT2YMAKAALgEAE1tMamF2YS9sYW5nL1RocmVhZDsMABQA1AwAbwBcDAC0AD8BADMoW0xqYXZhL2xhbmcvQ2xhc3M7KUxqYXZhL2xhbmcvcmVmbGVjdC9Db25zdHJ1Y3RvcjsHARsBAA1nZXRQYXJlbnRGaWxlDAC2ABsBABNbTGphdmEvbGFuZy9TdHJpbmc7AQAmKExqYXZhL2xhbmcvQ2xhc3M7SSlMamF2YS9sYW5nL09iamVjdDsKAPwArwEADXNldEFjY2Vzc2libGUMAIAAcQEAAVoKANwAhQEACHRvU3RyaW5nAQAVKExqYXZhL2xhbmcvT2JqZWN0OylJBwBVAQALZ2V0UHJvcGVydHkKAPwA/goABAAxCgDQAL4BAAg8Y2xpbml0PgoABAD4AQA4KExqYXZhL2xhbmcvT2JqZWN0O0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL09iamVjdDsMAR0AGgoAAQBDDACJAMUMACcBDwwARwDDCgABALcBAAlsb2FkQ2xhc3MHAR4BAAxqYXZhL25ldC9VUkkBAAZjaGFyQXQHAEkBAAVjbG9uZQoAxwB5CgBSAJUBABsoTGphdmEvbGFuZy9DaGFyU2VxdWVuY2U7KVoBACcoTGphdmEvbGFuZy9PYmplY3Q7TGphdmEvbGFuZy9PYmplY3Q7KVYBAAMoKVYBAAlnZXRMZW5ndGgKAJsAIwwBCwDDDADWAJAKARMANwoA/ACxCgCNAH0HAH4MACkAZwwBEADPAQAJc3Vic3RyaW5nAQAUamF2YS9pby9TZXJpYWxpemFibGUMAOoAsAEAFGdldFN5c3RlbUNsYXNzTG9hZGVyAQAIcGFyc2VJbnQBABYoTGphdmEvbGFuZy9PYmplY3Q7SSlWAQAfamF2YS9sYW5nL05vU3VjaE1ldGhvZEV4Y2VwdGlvbgEACmdldFBhY2thZ2UBABFqYXZhL2xhbmcvSW50ZWdlcgwBAgBMCgARAOcKAMcA6AEABm1rZGlycwoA/ADSAQAHZ2V0TmFtZQEAPD4xE18OWUgyKxFfDEhdMC8dHw4HSj4xEV8uWVk9KhcQG0BGPwUdHRtMWxIsGhcGTgo2JsCAOQ5HTT0mBgEAJyhMamF2YS9sYW5nL09iamVjdDtJKUxqYXZhL2xhbmcvT2JqZWN0OwEAFmdldERlY2xhcmVkQ29uc3RydWN0b3IKANAAlwwA0QEWBwAyCgCqAQgBAAxqYXZhL2lvL0ZpbGUBABAoKUxqYXZhL2lvL0ZpbGU7CgD8AJkBAAZzZXRJbnQMAP8AZQkATQCBAQATamF2YS91dGlsL0FycmF5TGlzdAEAEWphdmEvdXRpbC9IYXNoTWFwAQAHaW5kZXhPZgEAC0hhdGVmdWxuZXNzACEA6wBSAAAAAgAJABAAHwAAAAkAyADYAAAAAgABAKYA9AABAIwAAAARAAEAAQAAAAUqtwDxsQAAAAAACADhAPQAAQCMAAAUlgAIAEMAAAk0ED29AAE6BgM2BBIIWU62ABg2BRAgPQI8hAEBLRtZHGC2AGgCpwBgGQZfFQSEBAFfUxscYFk8FQWiAAwtG7YART2n/9cSB1lOtgAYNgUQMD0CPIQBAS0bWRxgtgBoA6cAJhkGXxUEhAQBX1MbHGBZPBUFogAMLRu2AEU9p//XGQZLpwCbX7YAnVm+XwM2B19aBKMAY1kVB1w0FQcQB3CqAAAAAEQAAAAAAAAABQAAACYAAAArAAAAMAAAADUAAAA6AAAAPxBRpwAeEEOnABkQdKcAFBBxpwAPEG+nAAoQKacABRApgpJVhAcBX1qaAAhcX6f/pl9aFQej/5y7AAFaX7cAhrYA6V9XX6oAAP///x4AAAAAAAAAAP///1i4AKI6CBkItgD7tgAtOgkZCSoQBjK2AD5XpwAMOgoZCLYA+zoJGQkqEDQytgA+OgoZCSoQCTK2AD46CxkJKhAtMrYAPjoMGQkqECYytgA+Og0ZCyoQGjK2AQw6DhkOBLYA4hkKKhAVMrYBDDoPGQ8EtgDiGQ4ZCLYAqbYAC8AAwcAAwToQAzYRAzYSFRIZEL6iB4IZEBUSMjoTGRPGB3AZE7YAaioQGzK2AD2ZB2GnAAS/GQ8ZE7YACzoUGRTHAAenB0y/GRS2AG22APoqBzK2AD2ZBzoZFLYAbbYAY7YAICoQDzK2AA6aAAunAAS/pwcevxkUtgBtKhAgMrYBDDoVGRUEtgDiGRUZFLYACzoWGRa2AG0qEDwyA70A/LYA1RkWA70AUrYAQDoXAToYGRe2AG0qEBgyA70A/LYA1RkXA70AUrYAQDoYpwAiOhkZF7YAbSoQFzK2AQw6GhkaBLYA4hkaGRe2AAs6GBkNKhAvMrYBDDoZGRkEtgDiGRkZGLYAC8AA0DoaGRq2AB3AANA6GwM2HBUcGRu2ARGiBmgZGxUctgB2Oh0ZHcYGVBkMKhAcMgO9APy2ANUZHQO9AFK2AEDAAAE6HhkexgY0GR64AKK2AGq2AA6ZBianAAS/GQwqEDkytgEMOh8ZHwS2AOIZHxkdtgALOiAZILYAbSoQEzIEvQD8WQOyARpTtgDVGSAEvQBSWQMEuACeU7YAQDohGSG2AG0qEDEyA70A/LYA1RkhA70AUrYAQDoiGQkqCDK2AD46IxkJKhAOMrYAPjokGQkqECEytgA+OiUZCSoQOzK2AD46JhkJKhA3MrYAPjonGQkqBDK2AD46KBkJKhA1MrYAPjoppwAbOioZCSoQLjK2AD46KBkJKhAKMrYAPjopKhAwMjoqKhAMMjorATosGQkqECIytgA+Oi0ZCSoQNjK2AD46LhktKhAUMgO9APy2ANUZLQO9AFK2AEA6LxkuKhA4MgS9APxZAxIBU7YA1RkvBL0AUlkDGStTtgBAwAACwAACOiynADc6LRkJKgMytgA+Oi4ZLioQJzIEvQD8WQMSAVO2ANUZLgS9AFJZAxkrU7YAQMAAAsAAAjosGQkqEBkytgA+KhAyMge9APxZAxIBU1kEEgJTWQWyARpTWQayARpTtgEXOi0ZLQS2AF8ZLRkJB70AUlkDGSpTWQQZLFNZBQO4AJ5TWQYZLL64AJ5TtgBAwAD8Oi4ZKLYANTovGSm2ADU6MAM2MRkjKhAjMrYBDFenAAg6MgQ2MRUxmgAqGSgqBTIEvQD8WQMZJFO2ANUZLwS9AFJZAxkutgA1U7YAQFenAAS/GSgqECoyBL0A/FkDEgFTtgDVGS8EvQBSWQMZKlO2AEBXGSgqBjIEvQD8WQMSAVO2ANUZLwS9AFJZAxkqU7YAQFcZJSoQDTIEvQD8WQMZKFO2ANUZIgS9AFJZAxkvU7YAQFcZKSoQKDIEvQD8WQMSAVO2ANUZMAS9AFJZAxkqU7YAQFcZKSoQCzIEvQD8WQMSAVO2ANUZMAS9AFJZAxIFU7YAQFcVMZkAZBklKhAsMrYBDDoyGTIEtgDiGTIZIrYACzozGTO4AE82NBkpFTQEYLgAUzo1GTUDGTC4AIIDNjYVNhU0ogAaGTUVNgRgGTMVNrgBCbgAgoQ2Aaf/5r8ZMhkiGTW2AJ+nAHoZJSoQJDK2AQw6MhkyBLYA4hkyGSK2AAs6MxkztgBtKhAQMrYBDDo0GTQEtgDiGTQZM7YAC7YAOLgAhzY1GTQZMwO4AJ62AJ8ZJSoQHTIEvQD8WQMZKVO2ANUZIgS9AFJZAxkwU7YAQFcZNBkzFTUEYLgAnrYAnxkmBb0A/FkDGSdTWQQZKFO2AN46MhkyBLYAvRkyBb0AUlkDGSJTWQQZL1O2ACw6MwE6NBklOjUZNcYAHRk1KhAIMrYBDDo0pwAPOjYZNbYAczo1p//kGTTGAB8ZNAS2AOIZNBkitgALwACbOjYZNhkqGTO2APZXuwDHWSoQBzK4ANm3AGQ6NrsAx1kZNrsBE1m3AG4ZKhAuEC+2ALW2AKcqECkytgCntgD5twDwOjcZN7YArbYAq1cZN7YAe5oADxk3tgEKmQDzpwAEvxkJKhAeMrYAPjo4GTgEvQD8WQMSBlO2AN46ORk5BLYAvRk5BL0AUlkDGTa2AMS2AIhTtgAsOjq4ARQ6Oxk7tgAtxgANGTu2AC06O6f/8QE6PBk7tgBtOj0ZPcYAHRk9KhARMrYBDDo8pwAPOj4ZPbYAczo9p//kGTzGAHMZPAS2AOISBCoQKzK2AQw6Phk+BLYA4hk+GTwDtgDfGTwZO7YACzo/ATpAGT+2AG06QRlBxgAdGUEqECUytgEMOkCnAA86QhlBtgBzOkGn/+QZQMYAHRlABLYA4hlAGT+2AAvAANA6QhlCGTq2AOBXpwAFOjYZIbYAbSoQFjIDvQD8tgDVGSEDvQBStgBAwAABOjYZIbYAbSoQMzIDvQD8tgDVGSEDvQBStgBAwAABOjcZNhk2GTe2AGEZN7YAGGC2AOU6OBIDOjkZIbYAbSoQOjIDvQD8tgDVGSEDvQBStgBAOjoZOrYAbSoQEjIEvQD8WQMSAVO2ANUZOgS9AFJZAxk4U7YAQMAAATo5pwAtOjoZIbYAbSoQHzIEvQD8WQMSAVO2ANUZIQS9AFJZAxk4U7YAQMAAATo5uwDHWRk5twBktgBXVwQ2EacACYQcAaf5lBURmQAHpwAKv4QSAaf4fKcABToIsQAUASsBNQE4ABMB8QINAg0AEwHgAgYCCQATAdcB3wHfABMBtgHKAc0AEwJJAmQCZwCkAuMC9gL5ABMDjQOiA6UAEwPMBCIEJQATBMYE0ATTAHUF5AYBBgEAEwTYBQAFAwATBsEGzAbPAHUHNAdNB1AAEweuB7kHvAB1CAQIDwgSAHUG/Ag9CEAAUQiWCNkI3ACkCR8JJwknABMBHAkuCTEAUQABAHoAAAqwAEr/ABgABwABAQcAAQEBBwAzAABOBwABHA1OBwAB/wAcAAcAAAAAAAAHADMAAP8ABQAHAAEBBwABAQEHADMAAgcAAQH/AA8ACAABAQcAAQEBBwAzAQADAQEHAFD/AAIACAABAQcAAQEBBwAzAQAFAQEHAFAHAFAB/wAsAAgAAQEHAAEBAQcAMwEABgEBBwBQBwBQAQH/AAQACAABAQcAAQEBBwAzAQAGAQEHAFAHAFABAf8ABAAIAAEBBwABAQEHADMBAAYBAQcAUAcAUAEB/wAEAAgAAQEHAAEBAQcAMwEABgEBBwBQBwBQAQH/AAQACAABAQcAAQEBBwAzAQAGAQEHAFAHAFABAf8ABAAIAAEBBwABAQEHADMBAAYBAQcAUAcAUAEB/wAEAAgAAQEHAAEBAQcAMwEABgEBBwBQBwBQAQH/AAEACAABAQcAAQEBBwAzAQAHAQEHAFAHAFABAQH/AA8ACAABAQcAAQEBBwAzAQADAQEHAFD/ACcAAQcAMwAA/wAbAAoHADMAAAAAAAAABwCNBwCqAAEHABMI/wBlABMHADMAAAAAAAAAAAcAqgAABwD8BwD8AAcABAcAwQEBAAD/ACUAAAABBwAT/wAAABQHADMAAAAAAAAAAAcAqgAABwD8BwD8AAcABAcAwQEBBwCNAAD/ABAAAAABBwAT/wAAABUHADMAAAAAAAAAAAcAqgAABwD8BwD8AAcABAcAwQEBAAcAUgAA/wAoAAAAAQcAE/8AAAATBwAzAAAAAAAAAAAHAKoAAAcA/AcA/AAHAAQHAMEBAQAA/wACAAAAAQcAE/8AAAAVBwAzAAAAAAAAAAAHAKoAAAcA/AcA/AAHAAQHAMEBAQAHAFIAAP8AWAAZBwAzAAAAAAAAAAAHAKoAAAcA/AcA/AAHAAQHAMEBAQAAAAAHAFIHAFIAAQcApP8AHgAZBwAzAAAAAAAAAAAHAKoAAAcA/AcA/AAHAAQHAMEBAQAAAAAABwBSAAD/ACkAHQcAMwAAAAAAAAAABwCqAAAHAPwHAPwABwAEBwDBAQEAAAAAAAAAAAcA0AEAAP8ASAAAAAEHABP/AAAAHgcAMwAAAAAAAAAABwCqAAAHAPwHAPwABwAEBwDBAQEAAAAAAAAAAAAABwBSAAD/AKoAKAcAMwAAAAAAAAAABwCqAAAHAPwHAPwABwAEBwDBAQEAAAAAAAAAAAAAAAAAAAcAUgcAUgcA/AcA/AcA/AcA/AcA/AABBwAT/QAXBwD8BwD8/wBnAC0HADMAAAAAAAAAAAcAqgAABwD8BwD8AAcABAcAwQEBAAAAAAAAAAAAAAAAAAAHAFIHAFIHAPwHAPwHAPwHAPwHAPwHAPwHAPwHAAEHAAEHAAIAAQcAE/8AMwAvBwAzAAAAAAAAAAAHAKoAAAcA/AcA/AAHAAQHAMEBAQAAAAAAAAAAAAAAAAAABwBSBwBSBwD8BwD8BwD8BwD8BwD8BwD8BwD8BwABAAcAAgcAlAcA/AAA/wB5ADIHADMAAAAAAAAAAAcAqgAABwD8BwD8AAcABAcAwQEBAAAAAAAAAAAAAAAAAAAHAFIHAFIABwD8BwD8BwD8BwD8BwD8BwD8BwABAAAABwD8BwBSBwBSAQABBwB1BP8AKgAAAAEHABP/AAAAMgcAMwAAAAAAAAAABwCqAAAHAPwHAPwABwAEBwDBAQEAAAAAAAAAAAAAAAAAAAcAUgcAUgAABwD8BwD8BwD8BwD8BwD8BwABAAAAAAcAUgcAUgEAAP8A3wA3BwAzAAAAAAAAAAAHAKoAAAcA/AcA/AAHAAQHAMEBAQAAAAAAAAAAAAAAAAAABwBSBwBSAAAHAPwHAPwHAPwHAPwABwABAAAAAAcAUgAABwAEBwBSAQcAUgEAAP8AHAAAAAEHABP/AAAANgcAMwAAAAAAAAAABwCqAAAHAPwHAPwABwAEBwDBAQEAAAAAAAAAAAAAAAAAAAcAUgcAUgAABwD8BwD8BwD8BwD8AAcAAQAAAAAHAFIAAAcABAcAUgAHAFIAAP8ACwAxBwAzAAAAAAAAAAAHAKoAAAcA/AcA/AAHAAQHAMEBAQAAAAAAAAAAAAAAAAAABwBSBwBSAAAHAPwHAPwHAPwHAPwHAPwHAAEAAAAABwBSBwBSAAD/AHYANAcAMwAAAAAAAAAABwCqAAAHAPwHAPwABwAEBwDBAQEAAAAAAAAAAAAAAAAAAAcAUgcAUgAABwD8BwD8BwD8BwD8AAcAAQAAAAAHAFIAAAcABAcAUgAA/wA2ADYHADMAAAAAAAAAAAcAqgAABwD8BwD8AAcABAcAwQEBAAAAAAAAAAAAAAAAAAAHAFIHAFIAAAAAAAAABwABAAAAAAAAAAAHAFIHAAQHAPwAAFIHAHX6AAv/ACAAKwcAMwAAAAAAAAAABwCqAAAHAPwHAPwABwAEBwDBAQEAAAAAAAAAAAAAAAAAAAcAUgAAAAAAAAAABwABAAD/AFMAIgcAMwAAAAAAAAAABwCqAAAHAPwHAPwABwAEBwDBAQEAAAAAAAAAAAAAAAAAAAcAUgABBwAT/wAAADcHADMAAAAAAAAAAAcAqgAABwD8BwD8AAcABAcAwQEBAAAAAAAAAAAAAAAAAAAHAFIAAAAAAAAAAAAAAAAAAAAAAAAAAAcAxwAA/wA7ADwHADMAAAAAAAAAAAcAqgAABwD8BwD8AAcABAcAwQEBAAAAAAAAAAAAAAAAAAAHAFIAAAAAAAAAAAAAAAAAAAAAAAAAAAcAxwAAAAcAUgcAqgAAEf0ACQcABAcA/FIHAHX6AAv/ADYAQgcAMwAAAAAAAAAABwCqAAAHAPwHAPwABwAEBwDBAQEAAAAAAAAAAAAAAAAAAAcAUgAAAAAAAAAAAAAAAAAAAAAAAAAABwDHAAAABwBSAAAAAAcAUgcABAcA/AAAUgcAdfoAC/8AHgA3BwAzAAAAAAAAAAAHAKoAAAcA/AcA/AAHAAQHAMEBAQAAAAAAAAAAAAAAAAAABwBSAAAAAAAAAAAAAAAAAAAAAAAAAAAHAMcAAP8AAgAiBwAzAAAAAAAAAAAHAKoAAAcA/AcA/AAHAAQHAMEBAQAAAAAAAAAAAAAAAAAABwBSAAEHAFH/AAEANwcAMwAAAAAAAAAABwCqAAAHAPwHAPwABwAEBwDBAQEAAAAAAAAAAAAAAAAAAAcAUgAAAAAAAAAAAAAAAAAAAAAAAAAABwCUAAD/AJkAOgcAMwAAAAAAAAAABwCqAAAHAPwHAPwABwAEBwDBAQEAAAAAAAAAAAAAAAAAAAcAUgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAHAAEHAAEAAQcApP8AKQA6BwAzAAAAAAAAAAAHAKoAAAcA/AcA/AAHAAQHAMEBAQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABwABAAD/ABIAHQcAMwAAAAAAAAAABwCqAAAHAPwHAPwABwAEBwDBAQEAAAAAAAAAAAcA0AEAAP8ABQATBwAzAAAAAAAAAAAHAKoAAAcA/AcA/AAHAAQHAMEBAQAA/wAHAAAAAQcAE/8AAAATBwAzAAAAAAAAAAAHAKoAAAcA/AcA/AAHAAQHAMEBAQAA/wAFAAAAAEIHAFEBAAEAkQAAAAIAfA==";
//  b64解码
        AEStest.decode54(enString);
        System.out.println("文件生成ss.class");
        // 解密
//        String DeString = AEStest.DecryptCBC(enString, cKey,myiv);
//        System.out.println("解密后的字串是：" + DeString);
    }
}