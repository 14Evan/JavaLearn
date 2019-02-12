package learn.company.interview;

public class TwoFileDirAbsdir {

    public static void main(String[] args) {

        System.out.println(absPath("/hel/a/b/c/d/file.c", "/hel/a/b/c/d/e/fileddd.c"));
    }

    /**
     * 计算fileb相对filea相对路径
     *
     * @param filea
     * @param fileb
     * @return
     */
    private static final String absPath(String filea, String fileb) {
//        if (StringUtils.isNullOrEmpty(filea)) {
//            // return null 或者 throw custom exception
//            // 正则check path的合法性
//        }

        StringBuilder stringbuilder = new StringBuilder();

        if (fileb.indexOf(filea) == 0) {
            return stringbuilder.append(fileb.replace(filea, "")).toString();
        }

        String[] fileaArr = filea.split("/");
        String[] filebArr = fileb.split("/");

        int maxLength = Math.max(fileaArr.length, filebArr.length);

        for (int i = 0; i < maxLength; i++) {
            String a = "", b = "";
            try {
                a = fileaArr[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                for (int ii = i; ii < maxLength; ii++) {
                    stringbuilder.append(filebArr[ii]).append("/");
                }
                break;
            }

            try {
                b = filebArr[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }

            if (a.equals(b)) {
                stringbuilder.append("../");
            } else {
                stringbuilder.append(b).append("/");
            }
        }
        return stringbuilder.toString();
    }
}
