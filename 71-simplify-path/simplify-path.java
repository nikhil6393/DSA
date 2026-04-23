class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        List<String> stack = new ArrayList<>();
        for (String part : parts) {
            if (part.equals("..")) {
                if (!stack.isEmpty()) stack.remove(stack.size() - 1);
            } else if (!part.isEmpty() && !part.equals(".")) {
                stack.add(part);
            }
        }
        return "/" + String.join("/", stack);
    }
}