/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 不知道为什么，运行时错误，样例可以测试通过，ac不了
 */
#include<stdio.h>
typedef struct ListNode
{
    int val;
    struct ListNode *next;
} ListNode,*LN;

int main()
{
    LN l1=(LN)malloc(sizeof(ListNode));
    LN l2=(LN)malloc(sizeof(ListNode));
    l1->val=2;
    return 0;
}

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 *//**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2)
{
    struct ListNode* result=l1;
    while(l1&&l2)
    {
        l1->val+=l2->val;
        if(l1->val>9)//产生进位
        {
            l1->val%=10;
            if(l1->next)//产生进位，l1后续位存在
                l1->next->val++;
            else//产生进位，l1后续不存在，建立新节点
            {
                l1->next=(struct ListNode*)malloc(sizeof(struct ListNode));
                l1->next->val=1;
            }
        }
        if(l1->next&&l2->next)//l1,l2焦点后移,l1可能较短，进位产生了新节点
        {
            l1=l1->next;
            l2=l2->next;
        }
        else if(l1->next)//l2较短提前结束，需要检查L1焦点后续位规范性
        {
            struct ListNode* p1=l1->next;
            while(p1->val>9){
              p1->val%=10;
            if(p1->next)//产生进位，l1后续位存在
               { p1->next->val++;
                p1=p1->next;
               }
            else//产生进位，l1已经检查到最后位置
            {
                p1->next=(struct ListNode*)malloc(sizeof(struct ListNode));
                p1->next->val=1;
                return result;
            }
                           }
            return result;
        }
        else//l1较短，且未产生进位，提前结束
        {
            l1->next=l2->next;
            return result;
        }
    }
    if(!l1)//l1为空情况
    result=l2;
    return result;
}
