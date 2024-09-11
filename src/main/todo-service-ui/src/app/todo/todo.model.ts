export interface ITodo {
  id: number;
  name?: string | null;
}

export type NewTodo = Omit<ITodo, 'id'> & { id: null };
